package emt.model.exceptions;

public class CountryNotFound extends RuntimeException{
    public CountryNotFound(Long id) {
        super("Country with id: {" + id + "} is not found.");
    }
}