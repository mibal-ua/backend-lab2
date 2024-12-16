package ua.mibal.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.controller.model.LoginForm;
import ua.mibal.controller.model.TokenDto;
import ua.mibal.controller.model.UserDto;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class AuthService {

    public String login(@Valid LoginForm loginForm) {
        return null;
    }

    public TokenDto register(@Valid UserDto user) {
        return null;
    }
}
