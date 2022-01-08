package kris.sanchez.imageshare.domain.users.config;

import kris.sanchez.imageshare.domain.users.models.User;
import kris.sanchez.imageshare.domain.users.repos.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepo userRepo) {
        return args -> {
            User bes = new User("realemail@email.com");

            userRepo.save(bes);

        };
    }
}
