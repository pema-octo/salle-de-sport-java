package fr.octo.craft.SalleDeSport.Abonnement.Query;

import fr.octo.craft.SalleDeSport.Abonnement.Domain.Abonnement;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementRepository;

final class ChiffreAffaireAbonnementsEnCoursQueryHandler {
    private AbonnementRepository abonnementRepository;

    ChiffreAffaireAbonnementsEnCoursQueryHandler(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    double handle(ChiffreAffaireAbonnementsEnCoursQuery query) {
        double chiffreAffaire = 0;

        for (Abonnement abonnementEnCours : abonnementRepository.abonnementsEnCours(query.date)) {
            chiffreAffaire += abonnementEnCours.restantDu();
        }

        return chiffreAffaire;
    }
}
