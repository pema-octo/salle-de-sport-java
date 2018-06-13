package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import fr.octo.craft.SalleDeSport.Formule.Domain.Prix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RéductionTest {

    @Test
    public void moins_25_pourcent() {

        assertEquals(
            300,
            Réduction.auTaux(0.25).appliquer(new Prix(400)),
            0
        );
    }

    @Test
    public void moins_20_pourcent() {

        assertEquals(
            80,
            Réduction.auTaux(0.20).appliquer(new Prix(100)),
            0
        );
    }
}
