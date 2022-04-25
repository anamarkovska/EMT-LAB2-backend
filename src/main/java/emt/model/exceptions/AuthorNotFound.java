package emt.model.exceptions;

public class AuthorNotFound extends RuntimeException{
    public AuthorNotFound(Long id) {
        super("Author with id: {" + id + "} is not found.");
    }
}