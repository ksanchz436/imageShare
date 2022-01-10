package kris.sanchez.imageshare.domain.post.repos;

import kris.sanchez.imageshare.domain.post.model.Post;
import kris.sanchez.imageshare.domain.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
Optional<Post> findPostByUser(User user);
}
