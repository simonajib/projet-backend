package com.example.ecole.repositories;

import com.example.ecole.entity.Role;
import com.example.ecole.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    long countByRole(Role role);
}