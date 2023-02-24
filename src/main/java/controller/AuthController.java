package controller;

import model.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.JwtTokenService;

@RestController
public class AuthController {
    @Autowired
    private JwtTokenService tokenService;
    @PostMapping("/auth")
    public JwtToken hello(Authentication auth){
        return new JwtToken(tokenService.generateToken(auth));
    }
}
