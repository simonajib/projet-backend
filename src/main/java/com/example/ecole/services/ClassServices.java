package com.example.ecole.services;

import com.example.ecole.entity.Classb;


import java.util.List;
import java.util.Optional;


public interface ClassServices {
    Optional<Classb> findByName(String name);

    public Classb SaveClass(Classb classe);
    public Classb UpdateClass(Classb classe);
    void DeleteClassById(Long Id);
    void DeleteAllClasss();
    Classb getClassById(Long Id);
    List<Classb> getAllClasss();

    Long countClasses();
}
