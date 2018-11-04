package ua.logos.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class AdvertDTO {

    private Long id;

    private LocalDate startAdvert;

    private LocalDate finishAdvert;

    private ModelDTO model;
}
