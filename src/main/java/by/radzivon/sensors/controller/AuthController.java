package by.radzivon.sensors.controller;

import by.radzivon.sensors.dto.auth.LoginForm;
import by.radzivon.sensors.dto.auth.SignUpForm;
import by.radzivon.sensors.exceptions.ResourceNotFoundException;
import by.radzivon.sensors.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("auth/signup")
    private ResponseEntity singUp(@RequestBody @Valid SignUpForm signUpForm) throws ResourceNotFoundException {
        return authService.signUp(signUpForm);
    }

    @PostMapping("auth/signin")
    private ResponseEntity signIn(@RequestBody @Valid LoginForm loginForm) {
        return authService.signIn(loginForm);
    }
}
