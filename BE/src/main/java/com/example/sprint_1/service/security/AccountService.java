package com.example.sprint_1.service.security;

import com.example.sprint_1.entity.security.Account;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
/**
 * Tran Minh Khoa code
 */
public interface AccountService {

    Account findAccountByUserName(String username);

    Integer findIdUserByUserName(String username);

    String existsByUserName(String username);

    Boolean existsById(Integer bookId);

    void addNew(String username, String password, String email, String token) throws MessagingException, UnsupportedEncodingException;

    Boolean findAccountByVerificationCode(String code);

    Boolean findAccountByVerificationCodeToResetPassword(String code);

    void addVerificationCode(String username) throws MessagingException, UnsupportedEncodingException;

    List<Account> getAllAccount();

    void addNew(String username, String password);

    void saveNewPassword(String password, String code);

    Boolean existsByEmail(String email);

}
