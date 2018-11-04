package ua.logos.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.AdvertDTO;
import ua.logos.entity.AdvertEntity;
import ua.logos.repository.AdvertRepository;
import ua.logos.service.AdvertService;
import ua.logos.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    private AdvertRepository advertRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveAdvert(AdvertDTO advertDTO) {
        AdvertEntity advertEntity = modelMapper.map(advertDTO, AdvertEntity.class);
        advertRepository.save(advertEntity);
    }

    @Override
    public List<AdvertDTO> findAllAdvert() {
        List<AdvertEntity> advertEntities = advertRepository.findAll();
        List<AdvertDTO> advertDTOS = modelMapper.mapAll(advertEntities, AdvertDTO.class);
        return advertDTOS;
    }

    @Override
    public AdvertDTO findAdvertById(Long id) {
        AdvertEntity advertEntity = advertRepository.findById(id).get();
        AdvertDTO advertDTO = modelMapper.map(advertEntity, AdvertDTO.class);
        return advertDTO;
    }
}
