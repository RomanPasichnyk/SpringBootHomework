package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.entity.enums.DriveType;
import ua.logos.entity.enums.FuelType;
import ua.logos.entity.enums.Transmission;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private BigDecimal engineCapacity;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    private DriveType driveType;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false, columnDefinition = "DECIMAL(8,2)")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private ManufacturerEntity manufacturer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
