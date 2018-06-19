package fr.octo.salle_de_sport.Abonnement.Domain;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PériodeTest {

    @Test
    public void ne_contient_pas_une_date() throws ParseException {
        Période période = new Période(
            MaDate.fromString("2018-06-01"),
            2
        );

        assertFalse(
            période.contient(
                MaDate.fromString("2018-05-01")
            )
        );
    }

    @Test
    public void contient_une_date() throws ParseException {
        Période période = new Période(
            MaDate.fromString("2018-06-01"),
            2
        );

        assertTrue(
            période.contient(
                MaDate.fromString("2018-07-01")
            )
        );
    }
}
