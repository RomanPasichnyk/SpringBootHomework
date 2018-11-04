package ua.logos.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.ModelDTO;
import ua.logos.entity.ModelEntity;
import ua.logos.repository.ModelRepository;
import ua.logos.service.ModelService;
import ua.logos.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveModel(ModelDTO modelDTO) {
        ModelEntity modelEntity = modelMapper.map(modelDTO, ModelEntity.class);
        modelRepository.save(modelEntity);
    }

    @Override
    public List<ModelDTO> findAllModel() {
        List<ModelEntity> modelEntities = modelRepository.findAll();
        List<ModelDTO> modelDTOS = modelMapper.mapAll(modelEntities, ModelDTO.class);
        return modelDTOS;
    }

    @Override
    public ModelDTO findModelById(Long id) {
        ModelEntity modelEntity = modelRepository.findById(id).get();
        ModelDTO modelDTO = modelMapper.map(modelEntity, ModelDTO.class);
        return modelDTO;
    }
}
