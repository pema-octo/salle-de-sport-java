package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementId;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepositoryException;
import fr.octo.salle_de_sport.Abonnements.Domain.DateCustom;
import fr.octo.salle_de_sport.Abonnements.Infrastructure.Database.AbonnementInMemoryRepository;
import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.Prix;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class RenouvellerLesAbonnementsAutomatiquementCommandHandlerTest {

    @Test
    public void handle() throws AbonnementRepositoryException {

        var abonnementRepository = new AbonnementInMemoryRepository();

        var abonnementId = new AbonnementId();

        abonnementRepository.store(
            new Abonnement(
                abonnementId,
                Abonné.nouveau("bob@octo.com", "Bob"),
                Formule.nouvelleAuMois(new Prix(200)),
                new DateCustom("2018-06-09")
            )
        );

        RenouvellerLesAbonnementsAutomatiquementCommandHandler tested = new RenouvellerLesAbonnementsAutomatiquementCommandHandler(
            abonnementRepository
        );

        tested.handle(
            new RenouvellerLesAbonnementsAutomatiquementCommand(
                new DateCustom("2018-07-09")
            )
        );

        var dateEnCoursAprèsRenouvellement = new DateCustom("2018-08-01");
        assertTrue(
            abonnementRepository.get(abonnementId).estEnCours(dateEnCoursAprèsRenouvellement)
        );

        var dateAprèsLaFinAprèsRenouvellement = new DateCustom("2018-08-10");
        assertTrue(
            abonnementRepository.get(abonnementId).seraFiniLe(dateAprèsLaFinAprèsRenouvellement)
        );
    }
}
