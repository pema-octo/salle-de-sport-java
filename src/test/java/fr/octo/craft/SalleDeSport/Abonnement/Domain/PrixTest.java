package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrixTest {

    @Test
    public void un_prix_a_une_valeur() {
        Prix prix = Prix.nouveau(400);

        assertEquals(400, prix.prix(), 0);
    }

    @Test
    public void on_peut_appliquer_une_réduction() {
        Prix prix = Prix.nouveau(400);

        Réduction réduction = Réduction.auTaux(0.75);

        assertEquals(300, prix.réduction(réduction).prix(), 0);
    }
}
