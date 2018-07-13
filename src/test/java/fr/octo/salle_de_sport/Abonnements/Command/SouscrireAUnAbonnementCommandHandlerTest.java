package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementSouscrit;
import fr.octo.salle_de_sport.Abonnements.Domain.MaDate;
import fr.octo.salle_de_sport.Adherents.Domain.Adhérent;
import fr.octo.salle_de_sport.Adherents.Domain.AdhérentId;
import fr.octo.salle_de_sport.Adherents.Domain.AdhérentRepository;
import fr.octo.salle_de_sport.Adherents.Domain.AdhérentRepositoryException;
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
    public void handle() throws AdhérentRepositoryException, FormuleRepositoryException {

        AdhérentRepository adhérentRepository = mock(AdhérentRepository.class);
        FormuleRepository formuleRepository = mock(FormuleRepository.class);
        AbonnementRepository abonnementRepository = mock(AbonnementRepository.class);

        AdhérentId adhérentId = AdhérentId.fromString("some unique string 1");
        Adhérent adhérent = Adhérent.nouveau(
            adhérentId,
            "bob@octo.com",
            "Bob"
        );
        when(adhérentRepository.get(adhérentId)).thenReturn(adhérent);

        FormuleId formuleId = FormuleId.fromString("some unique string 2");
        Formule formule = Formule.nouvelleALAnnée(formuleId, 500.0);
        when(formuleRepository.get(formuleId)).thenReturn(formule);

        SouscrireAUnAbonnementCommandHandler tested = new SouscrireAUnAbonnementCommandHandler(
            adhérentRepository,
            formuleRepository,
            abonnementRepository
        );

        AbonnementSouscrit abonnementSouscrit = tested.handle(
            new SouscrireAUnAbonnementCommand(
                adhérent,
                formule,
                MaDate.fromString("2018-06-10")
            )
        );

        verify(abonnementRepository).store(any(Abonnement.class));

        assertEquals(adhérentId, abonnementSouscrit.adhérentId());
        assertEquals(formuleId, abonnementSouscrit.formuleId());
    }
}
