package com.sda.spring.demo.services;

import com.sda.spring.demo.dto.UserDTO;
import com.sda.spring.demo.dto.UserDetailsDTO;
import com.sda.spring.demo.model.User;
import com.sda.spring.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<UserDetailsDTO> getUsers() {

        ModelMapper modelMapper = new ModelMapper();
        List<User> users = userRepository.findAll();
        Type listType = new TypeToken<List<UserDetailsDTO>>() {}.getType();

        return modelMapper.map(users, listType);
    }

    public UserDTO getUserById(Long id){

        Optional<User> user = userRepository.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user.get(),UserDTO.class);

        return userDTO;
    }
}
