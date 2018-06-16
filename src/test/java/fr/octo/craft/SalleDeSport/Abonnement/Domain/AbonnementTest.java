package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbonnementTest {

    @Test
    public void prix_de_base_pour_une_souscription_d_un_mois() {
        Abonnement abonnementSansRéduc = new Abonnement(
            AbonnementId.fromString("some unique string"),
            Adhérent.nouveau(AdhérentId.fromString("some unique string"), "bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(FormuleId.fromString("some unique string"), 300.0),
            premierJuin()
        );

        assertEquals(abonnementSansRéduc.prix(), 300, 0);
    }

    @Test
    public void moins_30_pourcent_pour_une_souscription_à_l_année() {
        Abonnement abonnementAvecRéducAnnée = new Abonnement(
            AbonnementId.fromString("some unique string"),
            Adhérent.nouveau(AdhérentId.fromString("some unique string"), "bob@octo.com", "Bob"),
            Formule.nouvelleALAnnée(FormuleId.fromString("some unique string"), 100.0),
            premierJuin()
        );

        assertEquals(abonnementAvecRéducAnnée.prix(), 70, 0);
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
        assertEquals(abonnementEtudiantAuMois.prix(), 80, 0);

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
        assertEquals(abonnementEtudiantAnnée.prix(), 50, 0);
    }

    @Test
    public void un_abonnement_peut_être_en_cours() throws ParseException {
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

    private MaDate premierJuin() {
        try {
            return MaDate.fromString("2018-06-01");
        } catch (Exception e) {
            return new MaDate();
        }
    }
}
