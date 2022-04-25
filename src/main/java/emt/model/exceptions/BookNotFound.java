package emt.model.exceptions;

public class BookNotFound extends RuntimeException{
    public BookNotFound(Long id) {
        super("Book with id: {" + id + "} is not found.");
    }
}
