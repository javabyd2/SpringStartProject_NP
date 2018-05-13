package com.sda.spring.demo.services;

import com.sda.spring.demo.dto.UserDTO;
import com.sda.spring.demo.model.User;
import com.sda.spring.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<User> getUsers() {
        return  userRepository.findAll();
    }

    public UserDTO getUserById(Long id){

        Optional<User> user = userRepository.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user.get(),UserDTO.class);

        return userDTO;
    }
}
