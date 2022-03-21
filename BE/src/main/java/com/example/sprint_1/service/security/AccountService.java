package com.example.sprint_1.service.security;

import com.example.sprint_1.entity.security.Account;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

//import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface AccountService {
    /**
     * Tran Minh Khoa
     */
    Account findAccountByUserName(String username);

    Integer findIdUserByUserName(String username);

    String existsByUserName(String username);

    Boolean existsById(Integer bookId);

//    void addNew(String username, String password, String email, String token) throws MessagingException, UnsupportedEncodingException;

    Boolean findAccountByVerificationCode(String code);

    Boolean findAccountByVerificationCodeToResetPassword(String code);

//    void addVerificationCode(String username) throws MessagingException, UnsupportedEncodingException;

    List<Account> getAllAccount();

<<<<<<< HEAD
    void addNew(String username, String password);
=======
    /*
    HauLC
     */
    void addNew(String username, String email, String password);
>>>>>>> 72757406d8117924b4411b003cf435dbbb361414

    void saveNewPassword(String password, String code);

    Boolean existsByEmail(String email);

<<<<<<< HEAD
=======
    /*
        HauLC
     */
    void updateAccount(String password, String email,String username);

>>>>>>> 72757406d8117924b4411b003cf435dbbb361414
}
