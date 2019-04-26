package fr.octo.salle_de_sport.Abonnés.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.*;
import fr.octo.salle_de_sport.Abonnés.Domain.*;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.Prix;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class AbonnementSouscritEventHandlerTest {

    @Test
    public void handle() throws AbonnementNotFoundException, AbonnéNotFoundException, EmailNotSendException {
        var formule = Formule.aLAnnée(new Prix(500));

        var abonné = new Abonné("bob@octo.com", "Bob");
        var abonnéRepository = mock(AbonnéRepository.class);
        when(abonnéRepository.get(abonné.id())).thenReturn(abonné);

        var abonnement = new Abonnement(
            abonné,
            formule,
            new DateCustom()
        );
        var abonnementRepository = mock(AbonnementRepository.class);
        when(abonnementRepository.get(abonnement.id())).thenReturn(abonnement);

        var mailer = mock(Mailer.class);

        var tested = new AbonnementSouscritEventHandler(
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
