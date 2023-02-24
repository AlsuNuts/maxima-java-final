package service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Service
public class RSAKeys {
    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;

    @Value("${rsa.privatekey.path}")
    private String privateKeyPath;
    @Value("${rsa.publickey.path}")
    private String publicKeyPath;

    @PostConstruct
    public void init() throws Exception {
        privateKey = readPrivateKey();
        publicKey = readPublicKey();

    }
    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    public RSAPublicKey getPublicKey() {
        return publicKey;
    }
    private RSAPrivateKey readPrivateKey() throws Exception {
        String key = Files.readString(Path.of(privateKeyPath), Charset.defaultCharset());
        String privateKeyPEM = key.
                replace("-----BEGIN PRIVATE KEY-----","").
                replace("-----END PRIVATE KEY-----", "").
                replace(System.lineSeparator(), "");
        byte[] encoded = Base64.getDecoder().decode(privateKeyPEM);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);

        return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }
    private RSAPublicKey readPublicKey() throws Exception {
        String key = Files.readString(Path.of(publicKeyPath), Charset.defaultCharset());
        String publicKeyPEM = key.
                replace("-----BEGIN PRIVATE KEY-----","").
                replace("-----END PRIVATE KEY-----", "").
                replace(System.lineSeparator(), "");
        byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }

}
