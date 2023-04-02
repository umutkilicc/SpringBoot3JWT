package com.SecurityJWT.SecurityJWT.controller;

import com.SecurityJWT.SecurityJWT.Dto.UserInfoDto;
import com.SecurityJWT.SecurityJWT.Dto.CompanyDto;
import com.SecurityJWT.SecurityJWT.Entity.UserInfo;
import com.SecurityJWT.SecurityJWT.Service.CompanyService;
import com.SecurityJWT.SecurityJWT.Service.JwtService;
import com.SecurityJWT.SecurityJWT.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return userService.addUser(userInfo);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody UserInfoDto userInfoDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userInfoDto.getUsername(), userInfoDto.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userInfoDto.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    @GetMapping("/all")
    public List<CompanyDto> getAll() {
        return companyService.getAll();
    }

}
