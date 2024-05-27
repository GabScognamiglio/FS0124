package it.epicode.lezione_jwt.controller;

import it.epicode.lezione_jwt.dto.UserDto;
import it.epicode.lezione_jwt.entity.User;
import it.epicode.lezione_jwt.exception.BadRequestException;
import it.epicode.lezione_jwt.exception.USerNotFoundException;
import it.epicode.lezione_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/api/users")
    public String saveUser(@RequestBody @Validated UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + s2));
        }
        return userService.saveUser(userDto);
    }

    @GetMapping("/api/users")
    public List<User> getAllUSers() {
        return userService.getAllUsers();
    }


    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable int id) {
        Optional<User> userOptional = userService.getUserById(id);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new USerNotFoundException("User with id " + id + " not found.");
        }
    }

    @PutMapping("/api/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody @Validated UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + s2));
        }
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/api/users/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }


}
