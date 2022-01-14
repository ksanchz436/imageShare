package kris.sanchez.imageshare.domain.post.service;

import kris.sanchez.imageshare.domain.post.exceptions.PostNotFoundException;
import kris.sanchez.imageshare.domain.post.model.Post;
import kris.sanchez.imageshare.domain.post.repos.PostRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private static Logger logger = (Logger) LoggerFactory.getLogger(PostServiceImpl.class);

    private PostRepository postRepo;

    @Autowired
    public PostServiceImpl(PostRepository postRepo){
        this.postRepo = postRepo;}


    public Post addNewPost (Post post){
        Post savedPost = postRepo.save(post);
            return savedPost;
        }


    public Post getPostById(Long id) throws PostNotFoundException {
        Optional<Post> postOptional = postRepo.findById(id);
        if(postOptional.isEmpty()){
            logger.error("Post with id {} does not exist", id);
            throw new PostNotFoundException("Post not found");
        }
        return postOptional.get();
    }

    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }


    public Post updatePost(Long id, Post post) throws PostNotFoundException{
        Optional<Post> postOptional = postRepo.findById(id);
        if (postOptional.isEmpty()){
            throw new PostNotFoundException("Post does not exist, can not update");
        }
        Post savedPost = postOptional.get();
//        savedPost.setPostParts(post.getPostParts());
//        savedPost.setName;

        return postRepo.save(savedPost);
    }

    public Boolean deletePost(Long postId) throws PostNotFoundException{
        Optional<Post> postOptional = postRepo.findById(postId);
        if(postOptional.isEmpty()){
            throw new PostNotFoundException("Post does not exist, can not delete");
        }
        Post postToDelete = postOptional.get();
        postRepo.delete(postToDelete);
        return true;
    }


}
