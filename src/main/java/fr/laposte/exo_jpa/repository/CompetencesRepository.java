package fr.laposte.exo_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import fr.laposte.exo_jpa.model.Competences;

public interface CompetencesRepository extends JpaRepository<Competences, Long>{

}
