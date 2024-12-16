package ua.mibal.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.mibal.controller.model.LoginForm;
import ua.mibal.controller.model.TokenDto;
import ua.mibal.controller.model.UserDto;
import ua.mibal.service.AuthService;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public TokenDto login(@Valid @RequestBody LoginForm loginForm) {
        String token = authService.login(loginForm);
        return TokenDto.builder()
                .token(token)
                .build();
    }

    @PostMapping("/register")
    @ResponseStatus(CREATED)
    public TokenDto register(@Valid @RequestBody UserDto user) {
        String token = authService.register(user);
        return TokenDto.builder()
                .token(token)
                .build();
    }
}
