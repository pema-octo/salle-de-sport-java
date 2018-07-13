package fr.octo.salle_de_sport.Abonnements.Query;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;

final class ChiffreAffaireAbonnementsEnCoursQueryHandler {

    private final AbonnementRepository abonnementRepository;

    ChiffreAffaireAbonnementsEnCoursQueryHandler(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    Double handle(ChiffreAffaireAbonnementsEnCoursQuery query) {

        Double chiffreAffaire = 0.0;

        for (Abonnement abonnementEnCours : abonnementRepository.abonnementsEnCours(query.date())) {
            chiffreAffaire += abonnementEnCours.restantDu();
        }

        return chiffreAffaire;
    }
}
