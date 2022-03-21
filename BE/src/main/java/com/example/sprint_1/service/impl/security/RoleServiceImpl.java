package com.example.sprint_1.service.impl.security;

import com.example.sprint_1.entity.security.Role;
import com.example.sprint_1.repository.security.RoleRepository;
import com.example.sprint_1.service.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public void setDefaultRole(int accountId, Integer roleId) {
        roleRepository.setDefaultRole(accountId, roleId);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAllRole();
    }

}
