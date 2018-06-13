package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PériodeTest {

    @Test
    public void ne_contient_pas_une_date() throws ParseException {
        Période période = new Période(
            new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-01"),
            2
        );

        assertFalse(
            période.contient(
                new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-01")
            )
        );
    }

    @Test
    public void contient_une_date() throws ParseException {
        Période période = new Période(
            new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-01"),
            2
        );

        assertTrue(
            période.contient(
                new SimpleDateFormat("yyyy-MM-dd").parse("2018-07-01")
            )
        );
    }
}
