package fr.octo.salle_de_sport.Abonnements.Query;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.DateCustom;
import fr.octo.salle_de_sport.Abonnements.Infrastructure.Database.AbonnementInMemoryRepository;
import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.Prix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChiffreAffaireAbonnementsEnCoursQueryHandlerTest {

    @Test
    public void chiffre_d_affaire_avec_aucun_abonnement_en_cours() {

        var tested = new ChiffreAffaireAbonnementsEnCoursQueryHandler(
            new AbonnementInMemoryRepository()
        );

        var chiffreAffaire = tested.handle(new ChiffreAffaireAbonnementsEnCoursQuery(aujourdhui()));

        assertEquals(0, chiffreAffaire, 0);
    }

    @Test
    public void chiffre_d_affaire_avec_abonnements_en_cours() {

        var formule = Formule.aLAnnée(new Prix(200));

        var abonnementRepository = new AbonnementInMemoryRepository();

        abonnementRepository.store(
            new Abonnement(
                new Abonné("bob@octo.com", "Bob"),
                formule,
                aujourdhui()
            )
        );
        abonnementRepository.store(
            new Abonnement(
                new Abonné("lucy@octo.com", "Lucy"),
                formule,
                dansUnMois()
            )
        );

        var tested = new ChiffreAffaireAbonnementsEnCoursQueryHandler(
            abonnementRepository
        );

        assertEquals(140, tested.handle(new ChiffreAffaireAbonnementsEnCoursQuery(aujourdhui())), 0);
        assertEquals(1, abonnementRepository.abonnementsEnCours(aujourdhui()).size());

        assertEquals(280, tested.handle(new ChiffreAffaireAbonnementsEnCoursQuery(dansUnMois())), 0);
        assertEquals(2, abonnementRepository.abonnementsEnCours(dansUnMois()).size());

        assertEquals(280, tested.handle(new ChiffreAffaireAbonnementsEnCoursQuery(dansDeuxMois())), 0);
        assertEquals(2, abonnementRepository.abonnementsEnCours(dansDeuxMois()).size());
    }

    private DateCustom aujourdhui() {
        return new DateCustom("2018-06-09");
    }

    private DateCustom dansUnMois() {
        return new DateCustom("2018-07-09");
    }

    private DateCustom dansDeuxMois() {
        return new DateCustom("2018-08-09");
    }
}
