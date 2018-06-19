package fr.octo.salle_de_sport.Abonnement.Query;

import fr.octo.salle_de_sport.Abonnement.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnement.Domain.AbonnementRepository;

import java.text.ParseException;

final class ChiffreAffaireAbonnementsEnCoursQueryHandler {

    private final AbonnementRepository abonnementRepository;

    ChiffreAffaireAbonnementsEnCoursQueryHandler(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    Double handle(ChiffreAffaireAbonnementsEnCoursQuery query) throws ParseException {

        Double chiffreAffaire = 0.0;

        for (Abonnement abonnementEnCours : abonnementRepository.abonnementsEnCours(query.date())) {
            chiffreAffaire += abonnementEnCours.restantDu();
        }

        return chiffreAffaire;
    }
}
