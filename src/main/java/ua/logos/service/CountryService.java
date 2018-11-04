package ua.logos.service;

import ua.logos.domain.CountryDTO;

import java.util.List;

public interface CountryService {

    void saveCountry(CountryDTO countryDTO);

    List<CountryDTO> findAllCountries();

    CountryDTO findCountryById(Long id);

    void updateCountry(CountryDTO countryDTO, Long id);

    void deleteCountry(Long id);


}
