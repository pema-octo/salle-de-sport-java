package fr.octo.craft.SalleDeSport.Adherent.Domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AdhérentTest {

    @Test
    public void un_adhérent_peut_être_créé_avec_un_email_et_un_nom() {
        Adhérent adhérent = Adhérent.nouveau(
            AdhérentId.fromString("some unique string"),
            "bob@octo.com",
            "Bob"
        );

        assertEquals("bob@octo.com", adhérent.email());
        assertEquals("Bob", adhérent.prénom());
    }

    @Test
    public void un_adhérent_n_est_pas_étudiant_par_défaut() {
        Adhérent adhérent = Adhérent.nouveau(
            AdhérentId.fromString("some unique string"),
            "bob@octo.com",
            "Bob"
        );

        assertFalse(adhérent.estEtudiant());
    }
}
