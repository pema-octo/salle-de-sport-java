package fr.octo.salle_de_sport.Abonnements.UseCases;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.DateCustom;
import fr.octo.salle_de_sport.Abonnements.Infrastructure.Database.AbonnementInMemoryRepository;
import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.Prix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChiffreAffairePourUnMoisDonnéTest {

    @Test
    public void chiffre_d_affaire_pour_un_mois_donné_avec_abonnements_en_cours() {

        var abonnementRepository = new AbonnementInMemoryRepository();

        var aujourdhui = new DateCustom("2018-06-09");
        var dansUnMois = new DateCustom("2018-07-09");

        abonnementRepository.store(
            new Abonnement(
                new Abonné("bob@octo.com", "Bob"),
                Formule.auMois(new Prix(50)),
                aujourdhui
            )
        );
        abonnementRepository.store(
            new Abonnement(
                new Abonné("lucy@octo.com", "Lucy"),
                Formule.aLAnnée(new Prix(500)),
                dansUnMois
            )
        );

        var tested = new ChiffreAffairePourUnMoisDonné(
            abonnementRepository
        );

        assertEquals(50, tested.handle(aujourdhui), 0);
        assertEquals(1, abonnementRepository.abonnementsEnCours(aujourdhui).size());

        assertEquals(350, tested.handle(dansUnMois), 0);
        assertEquals(1, abonnementRepository.abonnementsEnCours(dansUnMois).size());
    }
}
