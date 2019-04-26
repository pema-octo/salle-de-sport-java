package fr.octo.salle_de_sport.Abonnés.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.*;
import fr.octo.salle_de_sport.Abonnés.Domain.*;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.Prix;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class AbonnementSouscritEventHandlerTest {

    private AbonnementRepository abonnementRepository = mock(AbonnementRepository.class);
    private AbonnéRepository abonnéRepository = mock(AbonnéRepository.class);
    private Mailer mailer = mock(Mailer.class);

    private AbonnementSouscritEventHandler eventHandler;

    @Before
    public void setUp() {
        eventHandler = new AbonnementSouscritEventHandler(
            abonnéRepository,
            abonnementRepository,
            mailer
        );
    }

    @Test
    public void email_envoyé() throws AbonnementNotFoundException, AbonnéNotFoundException, EmailDeBienvenueALaSouscriptionPasEnvoyéException {

        final var formule = Formule.aLAnnée(new Prix(500));

        final var abonné = new Abonné("bob@octo.com", "Bob");

        var abonnement = new Abonnement(
            abonné,
            formule,
            new DateCustom()
        );

        when(abonnéRepository.get(abonné.id())).thenReturn(abonné);
        when(abonnementRepository.get(abonnement.id())).thenReturn(abonnement);
//        when(mailer.sendEmail(anyString(), anyString())).thenReturn()

        EmailDeBienvenueALaSouscriptionEnvoyé result = eventHandler.handle(
            new AbonnementSouscrit(
                abonné,
                formule,
                abonnement
            )
        );

        assertThat(result.email, is("bob@octo.com"));
        assertThat(result.abonnementId, is(abonnement.id()));
    }

    @Test
    public void email_pas_envoyé_quand_problème_mailer() throws AbonnementNotFoundException, AbonnéNotFoundException, EmailNotSendException {

        final var formule = Formule.aLAnnée(new Prix(500));

        final var abonné = new Abonné("bob@octo.com", "Bob");

        var abonnement = new Abonnement(
            abonné,
            formule,
            new DateCustom()
        );

        when(abonnéRepository.get(abonné.id())).thenReturn(abonné);
        when(abonnementRepository.get(abonnement.id())).thenReturn(abonnement);
        doThrow(EmailNotSendException.introuvable("ptms.octo.com")).when(mailer).sendEmail(anyString(), anyString());

        try {
            eventHandler.handle(
                new AbonnementSouscrit(
                    abonné,
                    formule,
                    abonnement
                )
            );
            fail("doit être en exception");
        } catch (EmailDeBienvenueALaSouscriptionPasEnvoyéException result) {
            assertThat(result.getMessage(), containsString("ptms.octo.com"));
        }

    }


}
