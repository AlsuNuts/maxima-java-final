
import model.Drug;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import repository.DrugsRepository;
import repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class MaximaJavaFinalApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired private PasswordEncoder encoder;
	public static void main(String[] args) {
		SpringApplication.run(MaximaJavaFinalApplication.class, args);
	}

	@Override
	public void run(String... args) {
		User admin = new User("admin",
				"-",
				"-",
				"-",
				encoder.encode("admin"),
				List.of("ROLE_ADMIN"),
				true);
		userRepository.save(admin);

	}
/*	@PostConstruct
	public void init(){

	}

 */