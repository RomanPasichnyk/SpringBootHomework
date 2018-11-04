package ua.logos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.ManufacturerDTO;
import ua.logos.service.ManufacturerService;

import java.util.List;

@RestController
@RequestMapping("manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @PostMapping
    public ResponseEntity<?> createManufacturer (@RequestBody ManufacturerDTO manufacturerDTO){
        manufacturerService.saveManufacturer(manufacturerDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAllManufacturer(){
        List<ManufacturerDTO> manufacturerDTOS = manufacturerService.findAllManufacturers();
        return new ResponseEntity<List<ManufacturerDTO>>(manufacturerDTOS, HttpStatus.OK);
    }

    @GetMapping("{manufacturerId}")
    public ResponseEntity<?> findManufacturerById(@PathVariable("manufacturerId") Long id) {
        ManufacturerDTO manufacturerDTO = manufacturerService.findManufacturerById(id);
        return new ResponseEntity<ManufacturerDTO>(manufacturerDTO, HttpStatus.OK);
    }

}
