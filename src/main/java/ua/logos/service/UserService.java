package ua.logos.service;

import ua.logos.domain.UserDTO;

import java.util.List;

public interface UserService {

    void saveUser(UserDTO userDTO);

    List<UserDTO> findAllUser();

    UserDTO findUserById(Long id);

}
