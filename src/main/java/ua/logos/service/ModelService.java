package ua.logos.service;

import ua.logos.domain.ModelDTO;

import java.util.List;

public interface ModelService {

    void saveModel(ModelDTO modelDTO);

    List<ModelDTO> findAllModel();

    ModelDTO findModelById(Long id);

}
