package com.example.ecole.repositories;

import com.example.ecole.entity.Classb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Classb, Long> {
    Optional<Classb> findByName(String name);

}
