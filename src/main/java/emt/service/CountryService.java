package emt.service;

import emt.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findByName(String name);
    List<Country> findByContinent(String continent);
    Optional<Country> findById(Long id);
    Optional<Country> saveCountry(String name, String continent);
    Optional<Country> editCountry(Long id, String name, String continent);
    void deleteById(Long id);
}