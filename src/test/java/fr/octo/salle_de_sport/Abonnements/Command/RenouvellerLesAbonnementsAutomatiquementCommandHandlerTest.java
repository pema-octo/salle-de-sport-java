package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.*;
import fr.octo.salle_de_sport.Abonnements.Infrastructure.Database.AbonnementInMemoryRepository;
import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class RenouvellerLesAbonnementsAutomatiquementCommandHandlerTest {

    @Test
    public void handle() throws AbonnementRepositoryException {

        AbonnementRepository abonnementRepository = new AbonnementInMemoryRepository();

        AbonnementId abonnementId = new AbonnementId();

        abonnementRepository.store(
            new Abonnement(
                abonnementId,
                Abonné.nouveau("bob@octo.com", "Bob"),
                Formule.nouvelleAuMois(200.0),
                new MaDate("2018-06-09")
            )
        );

        RenouvellerLesAbonnementsAutomatiquementCommandHandler tested = new RenouvellerLesAbonnementsAutomatiquementCommandHandler(
            abonnementRepository
        );

        tested.handle(
            new RenouvellerLesAbonnementsAutomatiquementCommand(
                new MaDate("2018-07-09")
            )
        );

        MaDate dateEnCoursAprèsRenouvellement = new MaDate("2018-08-01");
        assertTrue(
            abonnementRepository.get(abonnementId).estEnCours(dateEnCoursAprèsRenouvellement)
        );

        MaDate dateAprèsLaFinAprèsRenouvellement = new MaDate("2018-08-10");
        assertTrue(
            abonnementRepository.get(abonnementId).seraFiniLe(dateAprèsLaFinAprèsRenouvellement)
        );
    }
}
