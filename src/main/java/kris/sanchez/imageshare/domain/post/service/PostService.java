package kris.sanchez.imageshare.domain.post.service;

import kris.sanchez.imageshare.domain.post.model.Post;
import kris.sanchez.imageshare.domain.post.repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepo;

    @Autowired
    public PostService(PostRepository postRepo){
        this.postRepo = postRepo;

    }

    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    public void addNewPost (Post post){
        Optional<Post> postOptional = postRepo.findById(post.getId());
        if(postOptional.isPresent()){
            throw new IllegalStateException("post already exists");
        }
        postRepo.save(post);

    }

    public void deletePost(Long postId){
        boolean exist = postRepo.existsById(postId);
        if(!exist){
            throw new IllegalStateException(("post with id " + postId + " does not exist"));
        }
        postRepo.deleteById(postId);
    }

//    @Transactional
//    public void updatePost()


}
