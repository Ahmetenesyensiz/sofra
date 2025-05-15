package com.example.sofra_backend.service;

import com.example.sofra_backend.model.User;
import com.example.sofra_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Trying to load user by email: {}", email);
        return userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.warn("User not found for email: {}", email);
                    return new UsernameNotFoundException("User not found");
                });
    }

    public List<User> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        log.info("Fetching user with ID: {}", id);
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        log.info("Creating new user: {}", user);
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        log.info("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
    }




}
