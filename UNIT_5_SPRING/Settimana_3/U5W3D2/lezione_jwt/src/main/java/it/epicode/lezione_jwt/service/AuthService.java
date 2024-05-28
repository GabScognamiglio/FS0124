package it.epicode.lezione_jwt.service;

import it.epicode.lezione_jwt.dto.UserLoginDto;
import it.epicode.lezione_jwt.entity.User;
import it.epicode.lezione_jwt.exception.UnauthorizedException;
import it.epicode.lezione_jwt.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUserAndCreateToken(UserLoginDto userLoginDto){
        User user = userService.getUserByEmail(userLoginDto.getEmail());

        if (passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
            return jwtTool.createToken(user);
        }
        else {
            throw new UnauthorizedException("Wrong password!");
        }
    }
}
