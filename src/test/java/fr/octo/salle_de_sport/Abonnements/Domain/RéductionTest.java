package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéId;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RéductionTest {

    @Test
    public void moins_30_pourcent_à_l_année() {

        Réduction réductionAbonnementAnnuel = new Réduction(
            Abonné.nouveau(
                new AbonnéId("some unique string"),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleALAnnée(new FormuleId("some unique string"), 400.0)
        );

        assertEquals(Réduction.REDUC_ANNEE, réductionAbonnementAnnuel.taux(), 0);
    }

    @Test
    public void moins_20_pourcent_pour_les_étudiants() {

        Réduction réductionAbonnementEtudiant = new Réduction(
            Abonné.étudiant(
                new AbonnéId("some unique string"),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleAuMois(new FormuleId("some unique string"), 400.0)
        );

        assertEquals(Réduction.REDUC_ETUDIANT, réductionAbonnementEtudiant.taux(), 0);
    }

    @Test
    public void moins_50_pourcent_pour_les_étudiants_à_l_année() {

        Réduction réductionAbonnementEtudiantAnnuel = new Réduction(
            Abonné.étudiant(
                new AbonnéId("some unique string"),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleALAnnée(new FormuleId("some unique string"), 400.0)
        );

        assertEquals(Réduction.REDUC_ETUDIANT + Réduction.REDUC_ANNEE, réductionAbonnementEtudiantAnnuel.taux(), 0);
    }
}
