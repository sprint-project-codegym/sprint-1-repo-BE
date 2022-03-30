package com.example.sprint_1.service.security;

import com.example.sprint_1.entity.security.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    /**
     * Tran Minh Khoa
     */
    List<Role> findAllRole();

    void setDefaultRole(int accountId, Integer roleId);

    List<Role> getAllRoles();

}
