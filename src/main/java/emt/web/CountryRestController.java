package emt.web;

import emt.model.Country;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import emt.service.CountryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://library-emt-lab2-193025.herokuapp.com/")
@RequestMapping("/api/countries")
public class CountryRestController {
    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll(){
        return countryService.findAll();
    }
}
