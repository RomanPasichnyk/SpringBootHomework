package ua.logos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.CountryDTO;
import ua.logos.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<?> createCountry(@RequestBody CountryDTO countryDTO) {
        countryService.saveCountry(countryDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getCountry() {
        List<CountryDTO> countries = countryService.findAllCountries();
        return new ResponseEntity<List<CountryDTO>>(countries, HttpStatus.OK);
    }

    @GetMapping("{countryId}")
    public ResponseEntity<?> getCountryById(@PathVariable("countryId") Long id) {
        CountryDTO countryDTO = countryService.findCountryById(id);
        return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.OK);
    }

    @PostMapping("/update/{countryId}")
    public ResponseEntity<?> updateCountry(
            @RequestBody CountryDTO countryDTO,
            @PathVariable("countryId") Long id) {
        countryService.updateCountry(countryDTO, id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("{countryId}")
    public ResponseEntity<?> deleteCountry(@PathVariable("countryId") Long id) {
        countryService.deleteCountry(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
