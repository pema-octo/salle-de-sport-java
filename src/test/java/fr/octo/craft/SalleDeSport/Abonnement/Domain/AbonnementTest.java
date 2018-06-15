package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbonnementTest {

    @Test
    public void prix_de_base_pour_une_souscription_d_un_mois() {
        Abonnement abonnementSansRéduc = new Abonnement(
            AbonnementId.fromString(UUID.randomUUID().toString()),
            Adhérent.nouveau(AdhérentId.fromString(UUID.randomUUID().toString()), "bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(FormuleId.fromString(UUID.randomUUID().toString()), 300.0),
            premierJuin()
        );

        assertEquals(abonnementSansRéduc.prix(), 300, 0);
    }

    @Test
    public void moins_30_pourcent_pour_une_souscription_à_l_année() {
        Abonnement abonnementAvecRéducAnnée = new Abonnement(
            AbonnementId.fromString(UUID.randomUUID().toString()),
            Adhérent.nouveau(AdhérentId.fromString(UUID.randomUUID().toString()), "bob@octo.com", "Bob"),
            Formule.nouvelleALAnnée(FormuleId.fromString(UUID.randomUUID().toString()), 100.0),
            premierJuin()
        );

        assertEquals(abonnementAvecRéducAnnée.prix(), 70, 0);
    }

    @Test
    public void moins_20_pourcent_pour_la_souscription_d_un_étudiant() {
        Abonnement abonnementEtudiantAuMois = new Abonnement(
            AbonnementId.fromString(UUID.randomUUID().toString()),
            Adhérent.étudiant(
                AdhérentId.fromString(UUID.randomUUID().toString()),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleAuMois(FormuleId.fromString(UUID.randomUUID().toString()), 100.0),
            premierJuin()
        );
        assertEquals(abonnementEtudiantAuMois.prix(), 80, 0);

        Abonnement abonnementEtudiantAnnée = new Abonnement(
            AbonnementId.fromString(UUID.randomUUID().toString()),
            Adhérent.étudiant(
                AdhérentId.fromString(UUID.randomUUID().toString()),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleALAnnée(FormuleId.fromString(UUID.randomUUID().toString()), 100.0),
            premierJuin()
        );
        assertEquals(abonnementEtudiantAnnée.prix(), 50, 0);
    }

    @Test
    public void un_abonnement_peut_être_en_cours() throws ParseException {
        Abonnement abonnementEnCours = new Abonnement(
            AbonnementId.fromString(UUID.randomUUID().toString()),
            Adhérent.nouveau(
                AdhérentId.fromString(UUID.randomUUID().toString()),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleAuMois(FormuleId.fromString(UUID.randomUUID().toString()), 100.0),
            premierJuin()
        );

        Date dateCourantJuin = new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-09");

        assertTrue(abonnementEnCours.estEnCours(dateCourantJuin));
    }

    private Date premierJuin() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-01");
        } catch (Exception e) {
            return new Date();
        }
    }
}
