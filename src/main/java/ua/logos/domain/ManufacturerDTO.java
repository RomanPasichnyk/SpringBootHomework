package ua.logos.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ManufacturerDTO {

    private Long id;

    private String name;

    private CountryDTO country;

}
