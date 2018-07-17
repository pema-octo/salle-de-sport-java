package fr.octo.salle_de_sport.Formules.Command;

import fr.octo.salle_de_sport.Formules.Domain.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChangerLePrixDUneFormuleCommandHandlerTest {

    @Test
    public void handle() throws FormuleRepositoryException {
        FormuleId formuleId = new FormuleId();
        Formule formule = Formule.nouvelleALAnnée(formuleId, 450.0);

        FormuleRepository formuleRepository = mock(FormuleRepository.class);
        when(formuleRepository.get(formuleId)).thenReturn(formule);

        ChangerLePrixDUneFormuleCommandHandler tested = new ChangerLePrixDUneFormuleCommandHandler(formuleRepository);

        PrixFormuleChangé event = tested.handle(
            new ChangerLePrixDUneFormuleCommand(
                formuleId,
                new Prix(400)
            )
        );

        assertEquals(new Prix(450), event.ancienPrix());
        assertEquals(new Prix(400), event.nouveauPrix());
    }
}
