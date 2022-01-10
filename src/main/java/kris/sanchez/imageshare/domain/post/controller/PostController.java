package kris.sanchez.imageshare.domain.post.controller;

import kris.sanchez.imageshare.domain.post.model.Post;
import kris.sanchez.imageshare.domain.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/posts")
public class PostController {

   private PostService postService;

    @Autowired
    public PostController(PostService postService){
       this.postService = postService;
   }

   @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
   }

   @PostMapping
   public void addNewPost(@RequestBody Post post){
        postService.addNewPost(post);
   }

   @DeleteMapping(path = "{postId}")
    public void deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
   }





}
