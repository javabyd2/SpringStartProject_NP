package com.sda.spring.demo.services;

import com.sda.spring.demo.model.Role;
import com.sda.spring.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getCategory(){
        return roleRepository.findAll();
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }
}
