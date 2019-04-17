package fr.octo.salle_de_sport.Abonnements.UseCases;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.DateCustom;

final class ChiffreAffairePourUnMoisDonné {

    private final AbonnementRepository abonnementRepository;

    ChiffreAffairePourUnMoisDonné(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    Double handle(DateCustom date) {

        var chiffreAffaire = 0.0;

        for (Abonnement abonnementEnCours : abonnementRepository.abonnementsEnCours(date)) {
            chiffreAffaire += abonnementEnCours.restantDu();
        }

        return chiffreAffaire;
    }
}
