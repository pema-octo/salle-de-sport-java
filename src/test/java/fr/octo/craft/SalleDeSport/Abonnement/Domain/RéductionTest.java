package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class RéductionTest {

    @Test
    public void moins_30_pourcent_à_l_année() {

        Réduction réductionAbonnementAnnuel = Réduction.pourAbonnement(
            Adhérent.nouveau(
                AdhérentId.fromString(UUID.randomUUID().toString()),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleALAnnée(FormuleId.fromString(UUID.randomUUID().toString()), 400.0)
        );

        assertEquals(Réduction.REDUC_ANNEE, réductionAbonnementAnnuel.taux(), 0);
    }

    @Test
    public void moins_20_pourcent_pour_les_étudiants() {

        Réduction réductionAbonnementEtudiant = Réduction.pourAbonnement(
            Adhérent.étudiant(
                AdhérentId.fromString(UUID.randomUUID().toString()),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleAuMois(FormuleId.fromString(UUID.randomUUID().toString()), 400.0)
        );

        assertEquals(Réduction.REDUC_ETUDIANT, réductionAbonnementEtudiant.taux(), 0);
    }

    @Test
    public void moins_50_pourcent_pour_les_étudiants_à_l_année() {

        Réduction réductionAbonnementEtudiantAnnuel = Réduction.pourAbonnement(
            Adhérent.étudiant(
                AdhérentId.fromString(UUID.randomUUID().toString()),
                "bob@octo.com",
                "Bob"
            ),
            Formule.nouvelleALAnnée(FormuleId.fromString(UUID.randomUUID().toString()), 400.0)
        );

        assertEquals(Réduction.REDUC_ETUDIANT + Réduction.REDUC_ANNEE, réductionAbonnementEtudiantAnnuel.taux(), 0);
    }
}
