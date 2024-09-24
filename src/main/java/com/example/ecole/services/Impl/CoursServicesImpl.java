package com.example.ecole.services.Impl;

import com.example.ecole.entity.Cours;
import com.example.ecole.repositories.CoursRepository;
import com.example.ecole.services.CoursServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursServicesImpl implements CoursServices {

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public Optional<Cours> findByTitle(String title) {
        return coursRepository.findByTitle(title);
    }
    /**
     * Enregistre un nouveau cours.
     *
     * @param cours le cours à enregistrer
     * @return le cours enregistré
     */
    @Override
    public Cours SaveCours(Cours cours) {
        return coursRepository.save(cours);
    }

    /**
     * Met à jour un cours existant.
     *
     * @param cours le cours à mettre à jour
     * @return le cours mis à jour
     */
    @Override
    public Cours UpdateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    /**
     * Supprime un cours par son identifiant.
     *
     * @param Id l'identifiant du cours à supprimer
     */
    @Override
    public void DeleteCoursById(Long Id) {
        coursRepository.deleteById(Id);
    }

    /**
     * Supprime tous les cours.
     */
    @Override
    public void DeleteAllCours() {
        coursRepository.deleteAll();
    }

    /**
     * Récupère un cours par son identifiant.
     *
     * @param Id l'identifiant du cours à récupérer
     * @return le cours trouvé
     */
    @Override
    public Cours getCoursById(Long Id) {
        return coursRepository.findById(Id).get();
    }

    /**
     * Récupère tous les cours.
     *
     * @return une liste de tous les cours
     */
    @Override
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public Long countCourses() {
            return coursRepository.count();
        }
}
