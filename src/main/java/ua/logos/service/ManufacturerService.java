package ua.logos.service;

import ua.logos.domain.ManufacturerDTO;

import java.util.List;

public interface ManufacturerService {

    void saveManufacturer(ManufacturerDTO manufacturerDTO);

    List<ManufacturerDTO> findAllManufacturers();

    ManufacturerDTO findManufacturerById(Long id);
}
