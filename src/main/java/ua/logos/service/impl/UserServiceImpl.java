package ua.logos.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.UserDTO;
import ua.logos.entity.UserEntity;
import ua.logos.repository.UserRepository;
import ua.logos.service.UserService;
import ua.logos.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userRepository.save(userEntity);
    }

    @Override
    public List<UserDTO> findAllUser() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOS = modelMapper.mapAll(userEntities, UserDTO.class);
        return userDTOS;
    }

    @Override
    public UserDTO findUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        return userDTO;
    }
}
