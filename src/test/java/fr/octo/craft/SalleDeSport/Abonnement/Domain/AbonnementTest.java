package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbonnementTest {

    @Test
    public void prix_de_base_pour_une_souscription_d_un_mois() {
        Abonnement abonnement = Abonnement.souscrire(
            Adhérent.nouveau(AdhérentId.generate(), "bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(300),
            premierJuin()
        );

        assertEquals(abonnement.prix(), 300, 0);
    }

    @Test
    public void moins_30_pourcent_pour_une_souscription_à_l_année() {
        Abonnement abonnement = Abonnement.souscrire(
            Adhérent.nouveau(AdhérentId.generate(), "bob@octo.com", "Bob"),
            Formule.nouvelleALAnnée(100),
            premierJuin()
        );

        assertEquals(abonnement.prix(), 70, 0);
    }

    @Test
    public void moins_20_pourcent_pour_la_souscription_d_un_étudiant() {
        Abonnement abonnementMois = Abonnement.souscrire(
            Adhérent.étudiant(AdhérentId.generate(), "bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(100),
            premierJuin()
        );
        assertEquals(abonnementMois.prix(), 80, 0);

        Abonnement abonnementAnnée = Abonnement.souscrire(
            Adhérent.étudiant(AdhérentId.generate(), "bob@octo.com", "Bob"),
            Formule.nouvelleALAnnée(100),
            premierJuin()
        );
        assertEquals(abonnementAnnée.prix(), 50, 0);
    }

    @Test
    public void un_abonnement_peut_être_en_cours() throws ParseException {
        Abonnement abonnement = Abonnement.souscrire(
            Adhérent.nouveau(AdhérentId.generate(), "bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(100),
            premierJuin()
        );

        assertTrue(abonnement.estEnCours(new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-09")));
    }

    private Date premierJuin() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-01");
        } catch (Exception e) {
            return new Date();
        }
    }
}
