package fr.octo.salle_de_sport.Formules.UseCases;

import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepository;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepositoryException;
import fr.octo.salle_de_sport.Formules.Domain.Prix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChangerLePrixDUneFormuleTest {

    @Test
    public void handle() throws FormuleRepositoryException {
        var formule = Formule.aLAnnée(new Prix(450));

        var formuleRepository = mock(FormuleRepository.class);
        when(formuleRepository.get(formule.id())).thenReturn(formule);

        var tested = new ChangerLePrixDUneFormule(formuleRepository);

        var event = tested.handle(
            formule.id(),
            new Prix(400)
        );

        assertEquals(new Prix(450), event.ancienPrix);
        assertEquals(new Prix(400), event.nouveauPrix);
    }
}
