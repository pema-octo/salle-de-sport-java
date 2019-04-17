package fr.octo.salle_de_sport.Formules.UseCases;

import fr.octo.salle_de_sport.Formules.Domain.DuréeFormule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleCréée;
import fr.octo.salle_de_sport.Formules.Domain.Prix;
import fr.octo.salle_de_sport.Formules.Infrastructure.Database.FormuleInMemoryRepository;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CréerUneNouvelleFormuleTest {

    @Test
    public void creer_une_nouvelle_formule() {

        var tested = new CréerUneNouvelleFormule(
            new FormuleInMemoryRepository()
        );

        var formuleCréée = tested.handle(
            new Prix(300),
            DuréeFormule.MOIS
        );

        assertTrue(formuleCréée instanceof FormuleCréée);
    }
}
