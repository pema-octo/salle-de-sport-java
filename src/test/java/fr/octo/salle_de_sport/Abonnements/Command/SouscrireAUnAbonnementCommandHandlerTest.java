package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementSouscrit;
import fr.octo.salle_de_sport.Abonnements.Domain.MaDate;
import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéId;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepository;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepositoryException;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepository;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepositoryException;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SouscrireAUnAbonnementCommandHandlerTest {

    @Test
    public void handle() throws AbonnéRepositoryException, FormuleRepositoryException {

        AbonnéRepository abonnéRepository = mock(AbonnéRepository.class);
        FormuleRepository formuleRepository = mock(FormuleRepository.class);
        AbonnementRepository abonnementRepository = mock(AbonnementRepository.class);

        AbonnéId abonnéId = AbonnéId.fromString("some unique string 1");
        Abonné abonné = Abonné.nouveau(
            abonnéId,
            "bob@octo.com",
            "Bob"
        );
        when(abonnéRepository.get(abonnéId)).thenReturn(abonné);

        FormuleId formuleId = FormuleId.fromString("some unique string 2");
        Formule formule = Formule.nouvelleALAnnée(formuleId, 500.0);
        when(formuleRepository.get(formuleId)).thenReturn(formule);

        SouscrireAUnAbonnementCommandHandler tested = new SouscrireAUnAbonnementCommandHandler(
            abonnéRepository,
            formuleRepository,
            abonnementRepository
        );

        AbonnementSouscrit abonnementSouscrit = tested.handle(
            new SouscrireAUnAbonnementCommand(
                abonné,
                formule,
                MaDate.fromString("2018-06-10")
            )
        );

        verify(abonnementRepository).store(any(Abonnement.class));

        assertEquals(abonnéId, abonnementSouscrit.abonnéId());
        assertEquals(formuleId, abonnementSouscrit.formuleId());
    }
}
