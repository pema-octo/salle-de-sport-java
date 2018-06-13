package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RéductionTest {

    @Test
    public void moins_30_pourcent_à_l_année() {

        Réduction tested = new Réduction(
            Adhérent.nouveau("bob@octo.com", "Bob"),
            Formule.nouvelleALAnnée(400)
        );

        assertEquals(Réduction.REDUC_ANNEE, tested.taux(), 0);
    }

    @Test
    public void moins_20_pourcent_pour_les_étudiants() {

        Réduction tested = new Réduction(
            Adhérent.étudiant("bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(400)
        );

        assertEquals(Réduction.REDUC_ETUDIANT, tested.taux(), 0);
    }

    @Test
    public void moins_50_pourcent_pour_les_étudiants_à_l_année() {

        Réduction tested = new Réduction(
            Adhérent.étudiant("bob@octo.com", "Bob"),
            Formule.nouvelleALAnnée(400)
        );

        assertEquals(Réduction.REDUC_ETUDIANT + Réduction.REDUC_ANNEE, tested.taux(), 0);
    }
}
