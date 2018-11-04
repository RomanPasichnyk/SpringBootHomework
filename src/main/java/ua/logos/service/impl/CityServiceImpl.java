package ua.logos.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.CityDTO;
import ua.logos.entity.CityEntity;
import ua.logos.repository.CityRepository;
import ua.logos.service.CityService;
import ua.logos.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveCity(CityDTO cityDTO) {
        CityEntity cityEntity = modelMapper.map(cityDTO, CityEntity.class);
        cityRepository.save(cityEntity);
    }

    @Override
    public List<CityDTO> findAllCity() {
        List<CityEntity> cityEntities = cityRepository.findAll();
        List<CityDTO> cityDTOS = modelMapper.mapAll(cityEntities, CityDTO.class);
        return cityDTOS;
    }

    @Override
    public CityDTO findCityById(Long id) {
        CityEntity cityEntity = cityRepository.findById(id).get();
        CityDTO cityDTO = modelMapper.map(cityEntity, CityDTO.class);
        return cityDTO;
    }
}
