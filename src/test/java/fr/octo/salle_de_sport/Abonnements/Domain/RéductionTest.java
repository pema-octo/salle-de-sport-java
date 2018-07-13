package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Adherents.Domain.Adhérent;
import fr.octo.salle_de_sport.Adherents.Domain.AdhérentId;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RéductionTest {

    @Test
    public void moins_30_pourcent_à_l_année() {

        Réduction réductionAbonnementAnnuel = Réduction.pourAbonnement(
            Adhérent.nouveau(
                AdhérentId.fromString("some unique string"),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleALAnnée(FormuleId.fromString("some unique string"), 400.0)
        );

        assertEquals(Réduction.REDUC_ANNEE, réductionAbonnementAnnuel.taux(), 0);
    }

    @Test
    public void moins_20_pourcent_pour_les_étudiants() {

        Réduction réductionAbonnementEtudiant = Réduction.pourAbonnement(
            Adhérent.étudiant(
                AdhérentId.fromString("some unique string"),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleAuMois(FormuleId.fromString("some unique string"), 400.0)
        );

        assertEquals(Réduction.REDUC_ETUDIANT, réductionAbonnementEtudiant.taux(), 0);
    }

    @Test
    public void moins_50_pourcent_pour_les_étudiants_à_l_année() {

        Réduction réductionAbonnementEtudiantAnnuel = Réduction.pourAbonnement(
            Adhérent.étudiant(
                AdhérentId.fromString("some unique string"),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleALAnnée(FormuleId.fromString("some unique string"), 400.0)
        );

        assertEquals(Réduction.REDUC_ETUDIANT + Réduction.REDUC_ANNEE, réductionAbonnementEtudiantAnnuel.taux(), 0);
    }
}
