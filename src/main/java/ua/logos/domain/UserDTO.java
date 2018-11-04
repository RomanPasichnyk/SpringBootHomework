package ua.logos.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private CityDTO city;

}
