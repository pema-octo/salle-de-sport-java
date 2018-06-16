package fr.octo.craft.SalleDeSport.Adherent.Command;

import fr.octo.craft.SalleDeSport.Abonnement.Domain.*;
import fr.octo.craft.SalleDeSport.Adherent.Domain.*;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;
import org.junit.Test;

import java.util.Date;

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
            new Date()
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
