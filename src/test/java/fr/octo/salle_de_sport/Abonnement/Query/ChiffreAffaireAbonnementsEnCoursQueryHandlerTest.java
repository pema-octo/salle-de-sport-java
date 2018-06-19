package fr.octo.salle_de_sport.Abonnement.Query;

import fr.octo.salle_de_sport.Abonnement.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnement.Domain.AbonnementId;
import fr.octo.salle_de_sport.Abonnement.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnement.Domain.MaDate;
import fr.octo.salle_de_sport.Abonnement.Infrastructure.Database.AbonnementInMemoryRepository;
import fr.octo.salle_de_sport.Adherent.Domain.Adhérent;
import fr.octo.salle_de_sport.Adherent.Domain.AdhérentId;
import fr.octo.salle_de_sport.Formule.Domain.Formule;
import fr.octo.salle_de_sport.Formule.Domain.FormuleId;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class ChiffreAffaireAbonnementsEnCoursQueryHandlerTest {

    @Test
    public void chiffre_d_affaire_avec_aucun_abonnement_en_cours() throws ParseException {

        ChiffreAffaireAbonnementsEnCoursQueryHandler tested = new ChiffreAffaireAbonnementsEnCoursQueryHandler(
            new AbonnementInMemoryRepository()
        );

        Double chiffreAffaire = tested.handle(new ChiffreAffaireAbonnementsEnCoursQuery(aujourdhui()));

        assertEquals(0, chiffreAffaire, 0);
    }

    @Test
    public void chiffre_d_affaire_avec_abonnements_en_cours() throws ParseException {

        Formule formule = Formule.nouvelleALAnnée(
            FormuleId.fromString("some unique string"),
            200.0
        );

        AbonnementRepository abonnementRepository = new AbonnementInMemoryRepository();

        abonnementRepository.store(
            new Abonnement(
                AbonnementId.fromString("unique string 1"),
                Adhérent.nouveau(AdhérentId.fromString("unique string 2"), "bob@octo.com", "Bob"),
                formule,
                aujourdhui()
            )
        );
        abonnementRepository.store(
            new Abonnement(
                AbonnementId.fromString("unique string 3"),
                Adhérent.nouveau(AdhérentId.fromString("unique string 4"), "lucy@octo.com", "Lucy"),
                formule,
                dansUnMois()
            )
        );

        ChiffreAffaireAbonnementsEnCoursQueryHandler tested = new ChiffreAffaireAbonnementsEnCoursQueryHandler(
            abonnementRepository
        );

        assertEquals(140, tested.handle(new ChiffreAffaireAbonnementsEnCoursQuery(dansUnMois())), 0);
        assertEquals(1, abonnementRepository.abonnementsEnCours(dansUnMois()).size());

        assertEquals(280, tested.handle(new ChiffreAffaireAbonnementsEnCoursQuery(dansDeuxMois())), 0);
        assertEquals(2, abonnementRepository.abonnementsEnCours(dansDeuxMois()).size());
    }

    private MaDate aujourdhui() {
        try {
            return MaDate.fromString("2018-06-09");
        } catch (Exception e) {
            return new MaDate();
        }
    }

    private MaDate dansUnMois() {
        try {
            return MaDate.fromString("2018-07-09");
        } catch (Exception e) {
            return aujourdhui();
        }
    }

    private MaDate dansDeuxMois() {
        try {
            return MaDate.fromString("2018-08-09");
        } catch (Exception e) {
            return aujourdhui();
        }
    }
}
