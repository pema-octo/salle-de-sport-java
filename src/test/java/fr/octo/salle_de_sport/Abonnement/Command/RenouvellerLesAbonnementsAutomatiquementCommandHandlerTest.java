package fr.octo.salle_de_sport.Abonnement.Command;

import fr.octo.salle_de_sport.Abonnement.Domain.*;
import fr.octo.salle_de_sport.Abonnement.Infrastructure.Database.AbonnementInMemoryRepository;
import fr.octo.salle_de_sport.Adherent.Domain.Adhérent;
import fr.octo.salle_de_sport.Adherent.Domain.AdhérentId;
import fr.octo.salle_de_sport.Formule.Domain.Formule;
import fr.octo.salle_de_sport.Formule.Domain.FormuleId;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class RenouvellerLesAbonnementsAutomatiquementCommandHandlerTest {

    @Test
    public void handle() throws AbonnementRepositoryException {

        Formule formule = Formule.nouvelleAuMois(
            FormuleId.fromString("some unique string"),
            200.0
        );

        AbonnementRepository abonnementRepository = new AbonnementInMemoryRepository();

        AbonnementId abonnementId = AbonnementId.fromString("unique string 1");

        abonnementRepository.store(
            new Abonnement(
                abonnementId,
                Adhérent.nouveau(AdhérentId.fromString("unique string 2"), "bob@octo.com", "Bob"),
                formule,
                MaDate.fromString("2018-06-09")
            )
        );

        RenouvellerLesAbonnementsAutomatiquementCommandHandler tested = new RenouvellerLesAbonnementsAutomatiquementCommandHandler(
            abonnementRepository
        );

        tested.handle(
            new RenouvellerLesAbonnementsAutomatiquementCommand(
                MaDate.fromString("2018-07-09")
            )
        );

        MaDate dateEnCoursAprèsRenouvellement = MaDate.fromString("2018-08-01");
        assertTrue(
            abonnementRepository.get(abonnementId).estEnCours(dateEnCoursAprèsRenouvellement)
        );

        MaDate dateAprèsLaFinAprèsRenouvellement = MaDate.fromString("2018-08-10");
        assertTrue(
            abonnementRepository.get(abonnementId).seraFiniLe(dateAprèsLaFinAprèsRenouvellement)
        );
    }
}
