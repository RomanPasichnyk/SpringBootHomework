package ua.logos.service;

import ua.logos.domain.AdvertDTO;

import java.util.List;

public interface AdvertService {

    void saveAdvert(AdvertDTO advertDTO);

    List<AdvertDTO> findAllAdvert();

    AdvertDTO findAdvertById(Long id);

}
