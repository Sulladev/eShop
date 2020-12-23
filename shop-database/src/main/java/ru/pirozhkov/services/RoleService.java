package ru.pirozhkov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pirozhkov.entities.Role;
import ru.pirozhkov.entities.User;
import ru.pirozhkov.repositories.RoleRepository;

import java.util.Collection;
import java.util.List;


@Service("roleService")
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return  roleRepository.findAll();
    }
}
