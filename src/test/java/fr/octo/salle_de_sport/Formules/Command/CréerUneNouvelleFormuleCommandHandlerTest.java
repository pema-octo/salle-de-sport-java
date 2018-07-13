package fr.octo.salle_de_sport.Formules.Command;

import fr.octo.salle_de_sport.Formules.Domain.DuréeFormule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleCréée;
import fr.octo.salle_de_sport.Formules.Infrastructure.Database.FormuleInMemoryRepository;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CréerUneNouvelleFormuleCommandHandlerTest {

    @Test
    public void creer_une_nouvelle_formule() {

        CréerUneNouvelleFormuleCommandHandler tested = new CréerUneNouvelleFormuleCommandHandler(
            new FormuleInMemoryRepository()
        );

        FormuleCréée formuleCréée = tested.handle(
            new CréerUneNouvelleFormuleCommand(
                String.valueOf(300.0),
                DuréeFormule.MOIS.toString()
            )
        );

        assertTrue(formuleCréée instanceof FormuleCréée);
    }
}
