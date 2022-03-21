package com.example.sprint_1.repository.security;

import com.example.sprint_1.entity.security.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Integer> {
}
