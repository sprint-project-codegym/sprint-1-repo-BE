package com.example.sprint_1.controller;

import com.example.sprint_1.dto.security.payload.reponse.JwtResponse;
import com.example.sprint_1.dto.security.payload.reponse.MessageResponse;
import com.example.sprint_1.dto.security.payload.request.LoginRequest;
import com.example.sprint_1.dto.security.payload.request.ResetPassRequest;
import com.example.sprint_1.dto.security.payload.request.VerifyRequest;
import com.example.sprint_1.entity.security.Account;
import com.example.sprint_1.entity.security.Role;
import com.example.sprint_1.service.impl.security.AccountDetailsImpl;
import com.example.sprint_1.service.impl.security.jwt.JwtUtility;
import com.example.sprint_1.service.security.AccountService;
import com.example.sprint_1.service.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Tran Minh Khoa
 */
@RestController
@RequestMapping("/api/home")
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:4200")
public class SecurityController {
    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtility.generateJwtToken(loginRequest.getUsername());
        AccountDetailsImpl userDetails = (AccountDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        Account account = accountService.findAccountByUserName(loginRequest.getUsername());
        return ResponseEntity.ok(
                new JwtResponse(
                        jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        roles)
        );
    }

    @PostMapping("/verify")
    public ResponseEntity<?> VerifyEmail(@RequestBody VerifyRequest code) {
        Boolean isVerified = accountService.findAccountByVerificationCode(code.getCode());
        if (isVerified) {
            return ResponseEntity.ok(new MessageResponse("activated"));
        } else {
            return ResponseEntity.ok(new MessageResponse("error"));
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> reset(@RequestBody LoginRequest loginRequest) throws MessagingException, UnsupportedEncodingException {

        if (accountService.existsByUserName(loginRequest.getUsername()) != null) {
            accountService.addVerificationCode(loginRequest.getUsername());

            return ResponseEntity.ok(new MessageResponse("Sent email "));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Tài khoản không đúng"));
    }

    @PostMapping("/verify-password")
    public ResponseEntity<?> VerifyPassword(@RequestBody VerifyRequest code) {
        Boolean isVerified = accountService.findAccountByVerificationCodeToResetPassword(code.getCode());
        if (isVerified) {
            return ResponseEntity.ok(new MessageResponse("accepted"));
        } else {
            return ResponseEntity.ok(new MessageResponse("error"));
        }
    }

    @PostMapping("/do-reset-password")
    public ResponseEntity<?> doResetPassword(@RequestBody ResetPassRequest resetPassRequest) {
        accountService.saveNewPassword(encoder.encode(resetPassRequest.getPassword()), resetPassRequest.getCode());
        return ResponseEntity.ok(new MessageResponse("success"));
    }


    /**
     * Tran Minh Khoa - hien thi account list
     */
    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAllAccount() {
        List<Account> accountList = accountService.getAllAccount();
        if (accountList.isEmpty()) {
            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
    }

    /**
     * Tran Minh Khoa - hien thi account list
     */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getAllRole() {
        List<Role> roleList = this.roleService.findAllRole();
        if (roleList.isEmpty()) {
            return new ResponseEntity<List<Role>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK);
    }

}
