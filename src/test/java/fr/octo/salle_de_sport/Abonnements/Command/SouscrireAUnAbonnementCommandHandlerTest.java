package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.DateCustom;
import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepository;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepositoryException;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepository;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepositoryException;
import fr.octo.salle_de_sport.Formules.Domain.Prix;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SouscrireAUnAbonnementCommandHandlerTest {

    @Test
    public void handle() throws AbonnéRepositoryException, FormuleRepositoryException {

        var abonnéRepository = mock(AbonnéRepository.class);
        var formuleRepository = mock(FormuleRepository.class);
        var abonnementRepository = mock(AbonnementRepository.class);

        var abonné = new Abonné("bob@octo.com", "Bob");
        when(abonnéRepository.get(abonné.id())).thenReturn(abonné);

        var formule = Formule.aLAnnée(new Prix(500));
        when(formuleRepository.get(formule.id())).thenReturn(formule);

        var tested = new SouscrireAUnAbonnementCommandHandler(
            abonnéRepository,
            formuleRepository,
            abonnementRepository
        );

        var abonnementSouscrit = tested.handle(
            new SouscrireAUnAbonnementCommand(
                abonné.id(),
                formule.id(),
                new DateCustom("2018-06-10")
            )
        );

        verify(abonnementRepository).store(any(Abonnement.class));

        assertEquals(abonné.id(), abonnementSouscrit.abonnéId);
        assertEquals(formule.id(), abonnementSouscrit.formuleId);
    }
}
