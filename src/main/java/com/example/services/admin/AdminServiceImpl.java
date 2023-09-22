package com.example.services.admin;

import com.example.entities.User;
import com.example.enums.UserRole;
import com.example.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl {

    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void createAdminAccount() {
        User adminAccount = userRepository.findByRole(UserRole.ADMIN);
        if (adminAccount == null) {
            adminAccount = new User();
            adminAccount.setEmail("admin@test.com");
            adminAccount.setName("admin");
            adminAccount.setPassword(new BCryptPasswordEncoder().encode("123"));
            adminAccount.setRole(UserRole.ADMIN);
            userRepository.save(adminAccount);
        }
    }
}
