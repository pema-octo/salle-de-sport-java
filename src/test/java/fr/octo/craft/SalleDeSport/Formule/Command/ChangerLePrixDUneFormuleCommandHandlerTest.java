package fr.octo.craft.SalleDeSport.Formule.Command;

import fr.octo.craft.SalleDeSport.Formule.Domain.*;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChangerLePrixDUneFormuleCommandHandlerTest {

    @Test
    public void handle() throws FormuleRepositoryException {
        FormuleId formuleId = FormuleId.fromString(UUID.randomUUID().toString());
        Formule formule = Formule.nouvelleALAnnée(formuleId, 450.0);

        FormuleRepository formuleRepository = mock(FormuleRepository.class);
        when(formuleRepository.get(formuleId)).thenReturn(formule);

        ChangerLePrixDUneFormuleCommandHandler tested = new ChangerLePrixDUneFormuleCommandHandler(formuleRepository);

        PrixFormuleChangé event = tested.handle(
            new ChangerLePrixDUneFormuleCommand(
                formuleId,
                400.0
            )
        );

        assertEquals(400, event.nouveauPrix.montant(), 0);
    }
}
