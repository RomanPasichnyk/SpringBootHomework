package ua.logos.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.entity.enums.DriveType;
import ua.logos.entity.enums.FuelType;
import ua.logos.entity.enums.Transmission;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor

public class ModelDTO {

    private Long id;

    private String name;

    private BigDecimal engineCapacity;

    private FuelType fuelType;

    private DriveType driveType;

    private Transmission transmission;

    private String color;

    private BigDecimal price;

    private ManufacturerDTO manufacturer;

    private UserDTO user;

}
