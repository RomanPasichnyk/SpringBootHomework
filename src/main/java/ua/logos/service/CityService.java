package ua.logos.service;

import ua.logos.domain.CityDTO;

import java.util.List;

public interface CityService {

    void saveCity(CityDTO cityDTO);

    List<CityDTO> findAllCity();

    CityDTO findCityById(Long id);

}
