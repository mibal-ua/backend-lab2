package ua.mibal.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.mibal.controller.model.LoginForm;
import ua.mibal.controller.model.UserDto;
import ua.mibal.exception.BadRequestException;
import ua.mibal.exception.NotFoundException;
import ua.mibal.model.User;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class AuthService {
    private final JwtTokenService jwtTokenService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    

    public String login(@Valid LoginForm form) {
        try {
            User user = userService.getByEmail(form.email());
            validatePasswordCorrect(form.password(), user.getPassword());
            return jwtTokenService.generateJwtToken(user);
        } catch (NotFoundException e) {
            throw new BadRequestException("Incorrect credentials");
        }
    }

    public String register(@Valid UserDto form) {
        User user = userService.create(form);
        return jwtTokenService.generateJwtToken(user);
    }

    private void validatePasswordCorrect(String raw, String encoded) {
        if (!passwordEncoder.matches(raw, encoded)) {
            throw new BadRequestException("Incorrect credentials");
        }
    }
}
