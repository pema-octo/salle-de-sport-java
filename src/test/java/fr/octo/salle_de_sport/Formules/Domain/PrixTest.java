package fr.octo.salle_de_sport.Formules.Domain;

import fr.octo.salle_de_sport.Abonnements.Domain.Réduction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PrixTest {

    @Test
    public void un_prix_a_un_montant() {

        Prix prix = new Prix(400);

        assertEquals(new Prix(400), prix);
    }

    @Test
    public void on_peut_appliquer_une_réduction() {

        Prix prix = new Prix(400);
        Réduction réduction = Réduction.auTaux(0.25);

        Prix prixAprèsRéduction = prix.aprèsRéduction(réduction);

        assertEquals(new Prix(300), prixAprèsRéduction);
        assertNotEquals(prix, prixAprèsRéduction);
    }
}
