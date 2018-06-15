package fr.octo.craft.SalleDeSport.Abonnement.Query;

import fr.octo.craft.SalleDeSport.Abonnement.Domain.Abonnement;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementRepository;

final class ChiffreAffaireAbonnementsEnCoursQueryHandler {

    private final AbonnementRepository abonnementRepository;

    ChiffreAffaireAbonnementsEnCoursQueryHandler(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    Double handle(ChiffreAffaireAbonnementsEnCoursQuery query) {
        Double chiffreAffaire = 0.0;

        for (Abonnement abonnementEnCours : abonnementRepository.abonnementsEnCours(query.date)) {
            chiffreAffaire += abonnementEnCours.restantDu();
        }

        return chiffreAffaire;
    }
}
