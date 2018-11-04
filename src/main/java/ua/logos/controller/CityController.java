package ua.logos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.CityDTO;
import ua.logos.service.CityService;

import java.util.List;

@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<?> createCity(@RequestBody CityDTO cityDTO) {
        cityService.saveCity(cityDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getCity() {
        List<CityDTO> cityDTOS = cityService.findAllCity();
        return new ResponseEntity<List<CityDTO>>(cityDTOS, HttpStatus.OK);
    }

    @GetMapping("{cityId}")
    public ResponseEntity<?> getCityById(@PathVariable("cityId") Long id) {
        CityDTO cityDTO = cityService.findCityById(id);
        return new ResponseEntity<CityDTO>(cityDTO, HttpStatus.OK);
    }

}
