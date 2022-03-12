package com.example.sprint_1.repository.security;

import com.example.sprint_1.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
