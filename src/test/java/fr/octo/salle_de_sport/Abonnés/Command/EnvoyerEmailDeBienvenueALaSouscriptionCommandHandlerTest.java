package fr.octo.salle_de_sport.Abonnés.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.*;
import fr.octo.salle_de_sport.Abonnés.Domain.*;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class EnvoyerEmailDeBienvenueALaSouscriptionCommandHandlerTest {

    @Test
    public void handle() throws AbonnementRepositoryException, AbonnéRepositoryException {
        AbonnéId abonnéId = new AbonnéId("some unique string");
        AbonnementId abonnementId = new AbonnementId("some unique string");

        Formule formule = Formule.nouvelleALAnnée(
            new FormuleId("some unique string"),
            500.0
        );

        Abonné abonné = Abonné.nouveau(abonnéId, "bob@octo.com", "Bob");
        AbonnéRepository abonnéRepository = mock(AbonnéRepository.class);
        when(abonnéRepository.get(abonnéId)).thenReturn(abonné);

        Abonnement abonnement = new Abonnement(
            abonnementId,
            abonné,
            formule,
            new MaDate()
        );
        AbonnementRepository abonnementRepository = mock(AbonnementRepository.class);
        when(abonnementRepository.get(abonnementId)).thenReturn(abonnement);

        Mailer mailer = mock(Mailer.class);

        EnvoyerEmailDeBienvenueALaSouscriptionCommandHandler tested = new EnvoyerEmailDeBienvenueALaSouscriptionCommandHandler(
            abonnéRepository,
            abonnementRepository,
            mailer
        );

        tested.handle(
            new AbonnementSouscrit(
                abonné,
                formule,
                abonnement
            )
        );

        verify(mailer).sendEmail(anyString(), anyString());
    }
}
