package fr.octo.craft.salle_de_sport.Abonnement.Domain;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class MaDateTest {

    @Test
    public void fromString() throws ParseException {
        MaDate tested = MaDate.fromString("2018-06-16");

        assertTrue(tested.toDate() instanceof Date);
    }
}
