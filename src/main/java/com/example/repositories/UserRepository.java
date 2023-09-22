package com.example.repositories;

import com.example.entities.User;
import com.example.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByRole(UserRole userRole);

    Optional<User> findByEmail(String email);
}
