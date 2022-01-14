package kris.sanchez.imageshare.domain.post.exceptions;

public class PostNotFoundException extends Exception {
    public PostNotFoundException(String message){
        super(message);
    }
}
