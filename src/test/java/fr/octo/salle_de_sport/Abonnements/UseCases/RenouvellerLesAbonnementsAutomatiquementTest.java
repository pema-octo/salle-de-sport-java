package fr.octo.salle_de_sport.Abonnements.UseCases;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepositoryException;
import fr.octo.salle_de_sport.Abonnements.Domain.DateCustom;
import fr.octo.salle_de_sport.Abonnements.Infrastructure.Database.AbonnementInMemoryRepository;
import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.Prix;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class RenouvellerLesAbonnementsAutomatiquementTest {

    @Test
    public void handle() throws AbonnementRepositoryException {

        var abonnementRepository = new AbonnementInMemoryRepository();

        var abonnement = new Abonnement(
            new Abonné("bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(new Prix(200)),
            new DateCustom("2018-06-09")
        );

        abonnementRepository.store(abonnement);

        RenouvellerLesAbonnementsAutomatiquement tested = new RenouvellerLesAbonnementsAutomatiquement(
            abonnementRepository
        );

        tested.handle(
            new DateCustom("2018-07-09")
        );

        var dateEnCoursAprèsRenouvellement = new DateCustom("2018-08-01");
        assertTrue(
            abonnementRepository.get(abonnement.id()).estEnCours(dateEnCoursAprèsRenouvellement)
        );

        var dateAprèsLaFinAprèsRenouvellement = new DateCustom("2018-08-10");
        assertTrue(
            abonnementRepository.get(abonnement.id()).seraFiniLe(dateAprèsLaFinAprèsRenouvellement)
        );
    }
}
