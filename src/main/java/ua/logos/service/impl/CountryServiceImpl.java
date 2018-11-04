package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.CountryDTO;
import ua.logos.entity.CountryEntity;
import ua.logos.repository.CountryRepository;
import ua.logos.service.CountryService;
import ua.logos.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveCountry(CountryDTO countryDTO) {
        CountryEntity countryEntity = modelMapper.map(countryDTO, CountryEntity.class);
        countryRepository.save(countryEntity);
    }

    @Override
    public List<CountryDTO> findAllCountries() {
        List<CountryEntity> countryEntities = countryRepository.findAll();
        List<CountryDTO> countryDTOS = modelMapper.mapAll(countryEntities, CountryDTO.class);
        return countryDTOS;
    }

    @Override
    public CountryDTO findCountryById(Long id) {
        CountryEntity countryEntity = countryRepository.findById(id).get();
        CountryDTO countryDTO = modelMapper.map(countryEntity, CountryDTO.class);
        return countryDTO;
    }

    @Override
    public void updateCountry(CountryDTO countryDTO, Long id) {
        CountryEntity countryEntity = modelMapper.map(countryDTO, CountryEntity.class);
        countryEntity.setId(id);
//        countryEntity = countryRepository.findById(id).get();
//        countryEntity.setName(countryDTO.getName());
        countryRepository.save(countryEntity);
    }

    @Override
    public void deleteCountry(Long id) {
        CountryEntity countryEntity = countryRepository.findById(id).get();
        countryRepository.delete(countryEntity);
    }
}
