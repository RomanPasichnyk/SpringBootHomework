package ua.logos.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.ManufacturerDTO;
import ua.logos.entity.ManufacturerEntity;
import ua.logos.repository.ManufacturerRepository;
import ua.logos.service.ManufacturerService;
import ua.logos.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveManufacturer(ManufacturerDTO manufacturerDTO) {
        ManufacturerEntity manufacturerEntity = modelMapper.map(manufacturerDTO, ManufacturerEntity.class);
        manufacturerRepository.save(manufacturerEntity);
    }

    @Override
    public List<ManufacturerDTO> findAllManufacturers() {
        List<ManufacturerEntity> manufacturerEntities = manufacturerRepository.findAll();
        List<ManufacturerDTO> manufacturerDTOS = modelMapper.mapAll(manufacturerEntities, ManufacturerDTO.class);
        return manufacturerDTOS;
    }

    @Override
    public ManufacturerDTO findManufacturerById(Long id) {
        ManufacturerEntity manufacturerEntity = manufacturerRepository.findById(id).get();
        ManufacturerDTO manufacturerDTO = modelMapper.map(manufacturerEntity, ManufacturerDTO.class);
        return manufacturerDTO;
    }
}
