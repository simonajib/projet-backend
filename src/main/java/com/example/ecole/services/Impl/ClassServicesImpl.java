package com.example.ecole.services.Impl;

import com.example.ecole.entity.Classb;
import com.example.ecole.repositories.ClassRepository;
import com.example.ecole.services.ClassServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de l'interface de service pour l'entité Classb.
 * Cette classe contient la logique métier pour gérer les classes.
 */
@Service
public class ClassServicesImpl implements ClassServices {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public Optional<Classb> findByName(String name) {
        return classRepository.findByName(name);
    }
    /**
     * Enregistre une nouvelle classe.
     *
     * @param classe la classe à enregistrer
     * @return la classe enregistrée
     */
    @Override
    public Classb SaveClass(Classb classe) {
        return classRepository.save(classe);
    }

    /**
     * Met à jour une classe existante.
     *
     * @param classe la classe à mettre à jour
     * @return la classe mise à jour
     */
    @Override
    public Classb UpdateClass(Classb classe) {
        return classRepository.save(classe);
    }

    /**
     * Supprime une classe par son identifiant.
     *
     * @param Id l'identifiant de la classe à supprimer
     */
    @Override
    public void DeleteClassById(Long Id) {
        classRepository.deleteById(Id);
    }

    /**
     * Supprime toutes les classes.
     */
    @Override
    public void DeleteAllClasss() {
        classRepository.deleteAll();
    }

    /**
     * Récupère une classe par son identifiant.
     *
     * @param Id l'identifiant de la classe à récupérer
     * @return la classe trouvée
     */
    @Override
    public Classb getClassById(Long Id) {
        return classRepository.findById(Id).get();
    }

    /**
     * Récupère toutes les classes.
     *
     * @return une liste de toutes les classes
     */
    @Override
    public List<Classb> getAllClasss() {
        return classRepository.findAll();
    }

    public Long countClasses() {
        return classRepository.count();
    }
}
