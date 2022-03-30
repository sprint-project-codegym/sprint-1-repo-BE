package com.example.sprint_1.service.impl.security;

import com.example.sprint_1.entity.security.Account;
import com.example.sprint_1.repository.security.AccountRepository;
import com.example.sprint_1.service.security.AccountService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Tran Minh Khoa
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public Account findAccountByUserName(String username) {
        return accountRepository.findAccountByUserName(username);
    }

    @Override
    public Integer findIdUserByUserName(String username) {
        return accountRepository.findIdUserByUserName(username);
    }

    @Override
    public String existsByUserName(String username) {
        return accountRepository.existsByUserName(username);
    }

    @Override
    public Boolean existsById(Integer bookId) {
        return accountRepository.existsById(bookId);
    }

    @Override
    public void addNew(String username, String password, String email, String token) throws MessagingException, UnsupportedEncodingException {
        String randomCode = RandomString.make(64);
        accountRepository.addNew(username, password, false, randomCode, email, token);
        sendVerificationEmail(username, randomCode, email);
    }

    @Override
    public Boolean findAccountByVerificationCode(String code) {
        Account account = accountRepository.findAccountByVerificationCode(code);
        if (account == null || account.getIsEnable()) {
            return false;
        } else {
            account.setIsEnable(true);
            account.setVerificationCode(null);
            accountRepository.save(account);
            return true;
        }
    }

    @Override
    public Boolean findAccountByVerificationCodeToResetPassword(String code) {
        Account account = accountRepository.findAccountByVerificationCode(code);
        return account != null;
    }

    @Override
    public void addVerificationCode(String username) throws MessagingException, UnsupportedEncodingException {
        String code = RandomString.make(64);
        accountRepository.addVerificationCode(code, username);
        Account account = accountRepository.findAccountByVerificationCode(code);
        this.sendVerificationEmailForResetPassWord(account.getUserName(), code, account.getEmail());
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.getAllAccount();
    }

    @Override
    public void addNew(String username, String password) {
        accountRepository.addNewAccount(username, password);
    }

    @Override
    public void saveNewPassword(String password, String code) {
        accountRepository.saveNewPassword(password, code);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    public void sendVerificationEmail(String userName, String randomCode, String email) throws MessagingException, UnsupportedEncodingException {
        String subject = "Hãy xác thực email của bạn";
        String mailContent = "";
        String confirmUrl = "http://localhost:4200/verification?code=" + randomCode;

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setTo(email);
        helper.setFrom("khoa4755@gmail.com", "TÒA NHÀ CHO THUÊ");
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + userName + " ,<p>" + "<p> Nhấn vào link sau để xác thực email của bạn:</p>" +
                "<h3><a href='" + confirmUrl + "'>Link Xác thực( nhấn vào đây)!</a></h3>" +
                "<p>TÒA NHÀ CHO THUÊ</p>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }

    public void sendVerificationEmailForResetPassWord(String userName, String randomCode, String email) throws MessagingException, UnsupportedEncodingException {
        String subject = "Hãy xác thực email của bạn";
        String mailContent = "";
        String confirmUrl = "http://localhost:4200/verify-reset-password?code=" + randomCode;


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setFrom("khoa4755@gmail.com", "TÒA NHÀ CHO THUÊ");
        helper.setTo(email);
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + userName + " ,<p>" + "<p> Nhấn vào link sau để xác thực email của bạn:</p>" +
                "<h3><a href='" + confirmUrl + "'>Link xác thực( nhấn vào đây)!</a></h3>" +
                "<p>TÒA NHÀ CHO THUÊ</p>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }
}
