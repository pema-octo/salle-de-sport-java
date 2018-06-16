package fr.octo.craft.SalleDeSport.Abonnement.Command;

import fr.octo.craft.SalleDeSport.Abonnement.Domain.Abonnement;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementRepository;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementSouscrit;
import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentRepository;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentRepositoryException;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleRepository;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleRepositoryException;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SouscrireAUnAbonnementCommandHandlerTest {

    @Test
    public void handle() throws ParseException, AdhérentRepositoryException, FormuleRepositoryException {

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
                new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-10")
            )
        );

        verify(abonnementRepository).store(any(Abonnement.class));

        assertEquals(adhérentId, abonnementSouscrit.adhérentId());
        assertEquals(formuleId, abonnementSouscrit.formuleId());
    }
}
