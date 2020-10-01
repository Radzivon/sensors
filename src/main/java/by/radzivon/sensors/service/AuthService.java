package by.radzivon.sensors.service;

import by.radzivon.sensors.dto.auth.LoginForm;
import by.radzivon.sensors.dto.auth.SignUpForm;
import by.radzivon.sensors.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity signUp(SignUpForm signUpForm) throws ResourceNotFoundException;

    ResponseEntity signIn(LoginForm loginForm);
}
