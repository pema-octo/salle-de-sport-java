package fr.octo.salle_de_sport.Formules.Domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormuleTest {

    @Test
    public void on_peut_creer_une_nouvelle_formule_avec_un_prix_de_base_et_et_une_durée() {
        Formule formule = Formule.nouvelleAuMois(new FormuleId("some unique string"), 400.0);

        assertTrue(formule.id() instanceof FormuleId);
        assertEquals(new Prix(400), formule.prixDeBase());
        assertFalse(formule.estALannée());
    }
}
