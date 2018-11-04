package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.AdvertDTO;
import ua.logos.service.AdvertService;

import java.util.List;

@RestController
@RequestMapping("adverts")
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    @PostMapping
    public ResponseEntity<?> createAdvert(@RequestBody AdvertDTO advertDTO) {
        advertService.saveAdvert(advertDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAllAdvert(){
        List<AdvertDTO> advertDTOS = advertService.findAllAdvert();
        return new ResponseEntity<List<AdvertDTO>>(advertDTOS, HttpStatus.OK);
    }

    public ResponseEntity<?> findAdvertById(Long id) {
        AdvertDTO advertDTO = advertService.findAdvertById(id);
        return new ResponseEntity<AdvertDTO>(advertDTO, HttpStatus.OK);
    }

}
