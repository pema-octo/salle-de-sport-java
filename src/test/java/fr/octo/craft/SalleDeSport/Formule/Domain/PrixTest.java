package fr.octo.craft.SalleDeSport.Formule.Domain;

import fr.octo.craft.SalleDeSport.Abonnement.Domain.Réduction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PrixTest {

    @Test
    public void un_prix_a_un_montant() {

        Prix prix = new Prix(400.0);

        assertEquals(400, prix.montant(), 0);
    }

    @Test
    public void on_peut_appliquer_une_réduction() {

        Prix prix = new Prix(400.0);
        Réduction réduction = Réduction.auTaux(0.25);

        Prix prixAprèsRéduction = prix.appliqueRéduction(réduction);

        assertEquals(
            300,
            prixAprèsRéduction.montant(),
            0
        );
        assertNotEquals(prix, prixAprèsRéduction);
    }
}
