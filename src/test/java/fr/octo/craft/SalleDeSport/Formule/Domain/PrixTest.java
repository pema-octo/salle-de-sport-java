package fr.octo.craft.SalleDeSport.Formule.Domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrixTest {

    @Test
    public void un_prix_a_une_valeur() {
        Prix prix = new Prix(400);

        assertEquals(400, prix.prix(), 0);
    }
}
