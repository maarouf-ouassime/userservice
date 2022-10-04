package ma.maarouf.userservice;

import ma.maarouf.userservice.domain.AppRole;
import ma.maarouf.userservice.domain.AppUser;
import ma.maarouf.userservice.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(AppUserService appUserService) {
        return args -> {
            appUserService.saveRole(new AppRole(null, "USER"));
            appUserService.saveRole(new AppRole(null, "ADMIN"));
            appUserService.saveRole(new AppRole(null, "SUPER_ADMIN"));
            appUserService.saveRole(new AppRole(null, "MANAGER"));
            appUserService.saveRole(new AppRole(null, "OPERATOR"));

            appUserService.saveUser(new AppUser(null, "John Travolta", "john", "1234", null));
            appUserService.saveUser(new AppUser(null, "Will Smith", "will", "1234", null));
            appUserService.saveUser(new AppUser(null, "Jim Carry", "jim", "1234", null));
            appUserService.saveUser(new AppUser(null, "Arnold Schwarzenegger", "arnold", "1234", null));

            appUserService.addRoleToUser("john", "USER");
            appUserService.addRoleToUser("will", "USER");
            appUserService.addRoleToUser("jim", "USER");
            appUserService.addRoleToUser("arnold", "USER");
            appUserService.addRoleToUser("arnold", "ADMIN");
            appUserService.addRoleToUser("arnold", "SUPER_ADMIN");
        };
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
