package ua.logos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.ModelDTO;
import ua.logos.service.ModelService;

import java.util.List;

@RestController
@RequestMapping("models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping
    public ResponseEntity<?> createModel(@RequestBody ModelDTO modelDTO) {
        modelService.saveModel(modelDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAllModel() {
        List<ModelDTO> modelDTOS = modelService.findAllModel();
        return new ResponseEntity<List<ModelDTO>>(modelDTOS, HttpStatus.OK);
    }

    @GetMapping("{modelId}")
    public ResponseEntity<?> findModelById(@PathVariable("modelId") Long id) {
        ModelDTO modelDTO = modelService.findModelById(id);
        return new ResponseEntity<ModelDTO>(modelDTO, HttpStatus.OK);
    }

}
