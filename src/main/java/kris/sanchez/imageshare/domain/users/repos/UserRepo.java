package kris.sanchez.imageshare.domain.users.repos;

import kris.sanchez.imageshare.domain.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
