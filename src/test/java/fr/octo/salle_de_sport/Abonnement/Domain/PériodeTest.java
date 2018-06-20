package fr.octo.salle_de_sport.Abonnement.Domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PériodeTest {

    @Test
    public void ne_contient_pas_une_date() {
        Période tested = new Période(
            MaDate.fromString("2018-06-01"),
            2
        );

        assertFalse(
            tested.contient(
                MaDate.fromString("2018-08-01")
            )
        );
    }

    @Test
    public void contient_une_date() {
        Période tested = Période.fromString("2018-06-01 au 2018-08-01");

        assertTrue(
            tested.contient(
                MaDate.fromString("2018-07-01")
            )
        );
    }

    @Test
    public void est_avant_une_date() {
        Période tested = new Période(
            MaDate.fromString("2018-06-01"),
            2
        );

        assertFalse(
            tested.avantLaDate(
                MaDate.fromString("2018-07-31")
            )
        );
        assertTrue(
            tested.avantLaDate(
                MaDate.fromString("2018-08-01")
            )
        );
    }

    @Test
    public void suivante() {
        Période tested = new Période(
            MaDate.fromString("2018-06-01"),
            2
        );

        assertEquals(
            "2018-08-01 au 2018-09-30",
            tested.suivante().toString()
        );
    }
}
