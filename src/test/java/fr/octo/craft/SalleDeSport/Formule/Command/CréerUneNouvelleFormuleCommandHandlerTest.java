package fr.octo.craft.SalleDeSport.Formule.Command;

import fr.octo.craft.SalleDeSport.Formule.Domain.DuréeFormule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleCréée;
import fr.octo.craft.SalleDeSport.Formule.Infrastructure.Database.FormuleInMemoryRepository;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CréerUneNouvelleFormuleCommandHandlerTest {

    @Test
    public void creer_une_nouvelle_formule() {

        CréerUneNouvelleFormuleCommandHandler tested = new CréerUneNouvelleFormuleCommandHandler(
            new FormuleInMemoryRepository()
        );

        FormuleCréée formuleCréée = tested.handle(new CréerUneNouvelleFormuleCommand(300, DuréeFormule.MOIS));

        assertTrue(formuleCréée instanceof FormuleCréée);
    }
}
