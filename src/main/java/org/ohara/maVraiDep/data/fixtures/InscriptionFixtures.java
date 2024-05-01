package org.ohara.maVraiDep.data.fixtures;

import org.ohara.maVraiDep.data.entitties.AnneeScolaire;
import org.ohara.maVraiDep.data.entitties.Classe;
import org.ohara.maVraiDep.data.entitties.Etudiant;
import org.ohara.maVraiDep.data.entitties.Inscription;
import org.ohara.maVraiDep.data.repositories.AnneeScolaireRepository;
import org.ohara.maVraiDep.data.repositories.ClasseRepository;
import org.ohara.maVraiDep.data.repositories.EtudiantRepository;
import org.ohara.maVraiDep.data.repositories.InscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(7)
@RequiredArgsConstructor
//@Component
public class InscriptionFixtures implements CommandLineRunner {
    private final InscriptionRepository inscriptionRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final EtudiantRepository etudiantRepository;
    private final ClasseRepository classeRepository;

    @Override
    public void run(String... args) throws Exception {
        AnneeScolaire anneeScolaire = anneeScolaireRepository.findByIsActiveTrue();
        List<Classe> classeList = classeRepository.findAll();
        for (long i = 1L; i < 5L; i++){
            Etudiant etudiant = etudiantRepository.findById(i).orElse(null);
            Inscription inscription = new Inscription();
            inscription.setIsActive(true);
            inscription.setEtudiant(etudiant);
            inscription.setAnneeScolaire(anneeScolaire);
            inscription.setClasse(classeList.get((int) i % classeList.size()));
            inscriptionRepository.save(inscription);
        }
    }
}
