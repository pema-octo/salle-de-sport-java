package fr.octo.salle_de_sport.Abonnements.Query;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;

final class ChiffreAffairePourUnMoisDonnéQueryHandler {

    private final AbonnementRepository abonnementRepository;

    ChiffreAffairePourUnMoisDonnéQueryHandler(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    Double handle(ChiffreAffairePourUnMoisDonnéQuery query) {

        var chiffreAffaire = 0.0;

        for (Abonnement abonnementEnCours : abonnementRepository.abonnementsEnCours(query.date)) {
            chiffreAffaire += abonnementEnCours.restantDu();
        }

        return chiffreAffaire;
    }
}
