package kris.sanchez.imageshare.domain.post.service;

import kris.sanchez.imageshare.domain.post.exceptions.PostNotFoundException;
import kris.sanchez.imageshare.domain.post.model.Post;

import java.util.List;

public interface PostService {
    Post addNewPost(Post post);

    Post getPostById(Long id) throws PostNotFoundException;
    List<Post>getAllPosts();

    Post updatePost(Long id, Post post) throws PostNotFoundException;
    Boolean deletePost(Long id) throws PostNotFoundException;

}
