package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "adverts")
public class AdvertEntity extends BaseEntity {

    @Column(name = "start_advert", nullable = false, columnDefinition = "DATE")
    private LocalDate startAdvert;

    @Column(name = "finish_advert", nullable = false, columnDefinition = "DATE")
    private LocalDate finishAdvert;

    @OneToOne
    @JoinColumn(name = "model_id")
    private ModelEntity model;

}
