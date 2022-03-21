package com.example.sprint_1.repository.security;

import com.example.sprint_1.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
