package fr.octo.craft.SalleDeSport.Abonnement.Query;

import fr.octo.craft.SalleDeSport.Abonnement.Domain.Abonnement;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementRepository;
import fr.octo.craft.SalleDeSport.Abonnement.Infrastructure.Database.AbonnementInMemoryRepository;
import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ChiffreAffaireAbonnementsEnCoursQueryHandlerTest {

    @Test
    public void chiffre_d_affaire_avec_aucun_abonnement_en_cours() {

        ChiffreAffaireAbonnementsEnCoursQueryHandler tested = new ChiffreAffaireAbonnementsEnCoursQueryHandler(
            new AbonnementInMemoryRepository()
        );

        double chiffreAffaire = tested.handle(new ChiffreAffaireAbonnementsEnCoursQuery(new Date()));

        assertEquals(0, chiffreAffaire, 0);
    }

    @Test
    public void chiffre_d_affaire_avec_abonnements_en_cours() {

        Formule formule = Formule.nouvelleALAnnée(200);

        AbonnementRepository abonnementRepository = new AbonnementInMemoryRepository();
        abonnementRepository.store(
            new Abonnement(
                Adhérent.nouveau(AdhérentId.generate(), "bob@octo.com", "Bob"),
                formule,
                aujourdhui()
            )
        );
        abonnementRepository.store(
            new Abonnement(
                Adhérent.nouveau(AdhérentId.generate(), "lucy@octo.com", "Lucy"),
                formule,
                dansUnMois()
            )
        );

        ChiffreAffaireAbonnementsEnCoursQueryHandler tested = new ChiffreAffaireAbonnementsEnCoursQueryHandler(
            abonnementRepository
        );

        assertEquals(280, tested.handle(new ChiffreAffaireAbonnementsEnCoursQuery(dansDeuxMois())), 0);
        assertEquals(2, abonnementRepository.abonnementsEnCours(dansDeuxMois()).size());

        assertEquals(140, tested.handle(new ChiffreAffaireAbonnementsEnCoursQuery(dansUnMois())), 0);
        assertEquals(1, abonnementRepository.abonnementsEnCours(dansUnMois()).size());
    }

    private Date aujourdhui() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-09");
        } catch (Exception e) {
            return aujourdhui();
        }
    }

    private Date dansUnMois() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse("2018-07-09");
        } catch (Exception e) {
            return aujourdhui();
        }
    }

    private Date dansDeuxMois() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-09");
        } catch (Exception e) {
            return aujourdhui();
        }
    }
}
