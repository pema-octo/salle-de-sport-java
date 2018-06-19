package fr.octo.salle_de_sport.Adherent.Command;

import fr.octo.salle_de_sport.Abonnement.Domain.*;
import fr.octo.salle_de_sport.Adherent.Domain.*;
import fr.octo.salle_de_sport.Formule.Domain.Formule;
import fr.octo.salle_de_sport.Formule.Domain.FormuleId;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class EnvoyerEmailDeBienvenueALaSouscriptionCommandHandlerTest {

    @Test
    public void handle() throws AbonnementRepositoryException, AdhérentRepositoryException {
        AdhérentId adhérentId = AdhérentId.fromString("some unique string");
        AbonnementId abonnementId = AbonnementId.fromString("some unique string");

        Formule formule = Formule.nouvelleALAnnée(
            FormuleId.fromString("some unique string"),
            500.0
        );

        Adhérent adhérent = Adhérent.nouveau(adhérentId, "bob@octo.com", "Bob");
        AdhérentRepository adhérentRepository = mock(AdhérentRepository.class);
        when(adhérentRepository.get(adhérentId)).thenReturn(adhérent);

        Abonnement abonnement = new Abonnement(
            abonnementId,
            adhérent,
            formule,
            new MaDate()
        );
        AbonnementRepository abonnementRepository = mock(AbonnementRepository.class);
        when(abonnementRepository.get(abonnementId)).thenReturn(abonnement);

        Mailer mailer = mock(Mailer.class);

        EnvoyerEmailDeBienvenueALaSouscriptionCommandHandler tested = new EnvoyerEmailDeBienvenueALaSouscriptionCommandHandler(
            adhérentRepository,
            abonnementRepository,
            mailer
        );

        tested.handle(
            new AbonnementSouscrit(
                adhérent,
                formule,
                abonnement
            )
        );

        verify(mailer).sendEmail(anyString(), anyString());
    }
}
