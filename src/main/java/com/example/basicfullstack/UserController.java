package com.example.basicfullstack;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    //@Valid
    @PutMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public void updateUser( @RequestBody User user) {
        userService.updateUser(user);
    }
    @DeleteMapping("/{id}")
    //  @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}