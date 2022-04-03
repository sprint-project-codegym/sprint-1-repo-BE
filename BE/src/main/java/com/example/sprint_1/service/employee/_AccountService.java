package com.example.sprint_1.service.employee;

import com.example.sprint_1.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface _AccountService extends JpaRepository<Account,Integer> {
}
