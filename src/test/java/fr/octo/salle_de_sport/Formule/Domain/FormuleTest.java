package fr.octo.salle_de_sport.Formule.Domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormuleTest {

    @Test
    public void on_peut_creer_une_nouvelle_formule_avec_un_prix_de_base_et_et_une_durée() {
        Formule formule = Formule.nouvelleAuMois(FormuleId.fromString("some unique string"), 400.0);

        assertTrue(formule.id() instanceof FormuleId);
        assertEquals(400, formule.prixDeBase().montant(), 0);
        assertFalse(formule.estALannée());
    }
}
