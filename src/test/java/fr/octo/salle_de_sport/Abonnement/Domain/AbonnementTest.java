package fr.octo.salle_de_sport.Abonnement.Domain;

import fr.octo.salle_de_sport.Adherent.Domain.Adhérent;
import fr.octo.salle_de_sport.Adherent.Domain.AdhérentId;
import fr.octo.salle_de_sport.Formule.Domain.Formule;
import fr.octo.salle_de_sport.Formule.Domain.FormuleId;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbonnementTest {

    @Test
    public void prix_de_base_pour_une_souscription_d_un_mois() {
        Abonnement abonnementSansRéduc = new Abonnement(
            AbonnementId.fromString("some unique string"),
            Adhérent.nouveau(AdhérentId.fromString("some unique string"), "bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(FormuleId.fromString("some unique string"), 300.0),
            premierJuin()
        );

        assertEquals(300, abonnementSansRéduc.prix().montant(), 0);
    }

    @Test
    public void moins_30_pourcent_pour_une_souscription_à_l_année() {
        Abonnement abonnementAvecRéducAnnée = new Abonnement(
            AbonnementId.fromString("some unique string"),
            Adhérent.nouveau(AdhérentId.fromString("some unique string"), "bob@octo.com", "Bob"),
            Formule.nouvelleALAnnée(FormuleId.fromString("some unique string"), 100.0),
            premierJuin()
        );

        assertEquals(70, abonnementAvecRéducAnnée.prix().montant(), 0);
    }

    @Test
    public void moins_20_pourcent_pour_la_souscription_d_un_étudiant() {
        Abonnement abonnementEtudiantAuMois = new Abonnement(
            AbonnementId.fromString("some unique string"),
            Adhérent.étudiant(
                AdhérentId.fromString("some unique string"),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleAuMois(FormuleId.fromString("some unique string"), 100.0),
            premierJuin()
        );
        assertEquals(80, abonnementEtudiantAuMois.prix().montant(), 0);

        Abonnement abonnementEtudiantAnnée = new Abonnement(
            AbonnementId.fromString("some unique string"),
            Adhérent.étudiant(
                AdhérentId.fromString("some unique string"),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleALAnnée(FormuleId.fromString("some unique string"), 100.0),
            premierJuin()
        );
        assertEquals(50, abonnementEtudiantAnnée.prix().montant(), 0);
    }

    @Test
    public void un_abonnement_peut_être_en_cours() {
        Abonnement abonnementEnCours = new Abonnement(
            AbonnementId.fromString("some unique string"),
            Adhérent.nouveau(
                AdhérentId.fromString("some unique string"),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleAuMois(FormuleId.fromString("some unique string"), 100.0),
            premierJuin()
        );

        MaDate dateCourantJuin = MaDate.fromString("2018-06-09");

        assertTrue(abonnementEnCours.estEnCours(dateCourantJuin));
    }

    @Test
    public void permet_de_déterminer_s_il_sera_fini_à_une_date() {
        Abonnement abonnementFiniFinJuin = new Abonnement(
            AbonnementId.fromString("some unique string"),
            Adhérent.nouveau(
                AdhérentId.fromString("some unique string"),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleAuMois(FormuleId.fromString("some unique string"), 100.0),
            premierJuin()
        );

        assertFalse(abonnementFiniFinJuin.seraFiniLe(MaDate.fromString("2018-06-30")));
        assertTrue(abonnementFiniFinJuin.seraFiniLe(MaDate.fromString("2018-07-01")));
    }

    @Test
    public void peut_être_renouvellé() {
        Abonnement abonnement = new Abonnement(
            AbonnementId.fromString("some unique string"),
            Adhérent.nouveau(
                AdhérentId.fromString("some unique string"),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleAuMois(FormuleId.fromString("some unique string"), 100.0),
            premierJuin()
        );

        assertFalse(abonnement.seraFiniLe(MaDate.fromString("2018-06-30")));
        assertTrue(abonnement.seraFiniLe(MaDate.fromString("2018-07-01")));

        abonnement.renouveller();

        assertFalse(abonnement.seraFiniLe(MaDate.fromString("2018-07-31")));
        assertTrue(abonnement.seraFiniLe(MaDate.fromString("2018-08-01")));
    }

    private MaDate premierJuin() {
        return MaDate.fromString("2018-06-01");
    }
}
