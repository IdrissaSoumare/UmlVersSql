package fr.laposte.exo_jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.exo_jpa.model.Apprenants;
import fr.laposte.exo_jpa.model.Competences;
import fr.laposte.exo_jpa.model.DossierAdministratif;
import fr.laposte.exo_jpa.model.SessionFormation;
import fr.laposte.exo_jpa.repository.ApprenantsRepository;
import fr.laposte.exo_jpa.repository.CompetencesRepository;
import fr.laposte.exo_jpa.repository.DossierAdministratifRepository;
import fr.laposte.exo_jpa.repository.SessionFormationRepository;

@SpringBootTest
class ExoJpaApplicationTests {

	@Autowired
	private ApprenantsRepository apprenants;

	@Autowired
	private SessionFormationRepository session;
	
	@Autowired
	private CompetencesRepository savoirFaire;
	
	@Autowired
	private DossierAdministratifRepository papiers;
	
	
	@BeforeEach
	void clean() {
		apprenants.deleteAll();
		papiers.deleteAll();
		session.deleteAll();
		savoirFaire.deleteAll();
	}

	@Test
	void contextLoads() {
		SessionFormation formation = new SessionFormation();
		formation.setLibelle("programmation");
		session.save(formation);

		Apprenants seve = new Apprenants();
		seve.setNom("pouki");
		seve.setPrenom("seve");
		seve.setSession(formation);
		apprenants.save(seve);

		Apprenants kriss = new Apprenants();
		kriss.setNom("Milo");
		kriss.setPrenom("kriss");
		kriss.setSession(formation);
		apprenants.save(kriss);
		
		Competences java = new Competences();
		java.setLibelle("java");
		java.setNiveau(1);
		savoirFaire.save(java);
		
		Competences sql = new Competences();
		sql.setLibelle("sql");
		sql.setNiveau(2);
		savoirFaire.save(sql);
		
		Competences javascript = new Competences();
		javascript.setLibelle("javascript");
		javascript.setNiveau(3);
		savoirFaire.save(javascript);
		
		DossierAdministratif xavier = new DossierAdministratif();
		xavier.setTuteurNom("Stef");
		xavier.setTuteurEmail("stef@gmail.com");
		papiers.save(xavier);
		
		DossierAdministratif martin = new DossierAdministratif();
		martin.setTuteurNom("Stef");
		martin.setTuteurEmail("stef@gmail.com");
		papiers.save(martin);
		
		kriss.getMaitrise().add(javascript);
		kriss.getMaitrise().add(sql);
		apprenants.save(kriss);
		seve.getMaitrise().add(java);
		seve.getMaitrise().add(javascript);
		apprenants.save(seve);
		
	}

}
