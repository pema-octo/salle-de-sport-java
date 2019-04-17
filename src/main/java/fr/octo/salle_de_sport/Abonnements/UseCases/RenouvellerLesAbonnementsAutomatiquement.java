package fr.octo.salle_de_sport.Abonnements.UseCases;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementsRenouvellésAutomatiquement;
import fr.octo.salle_de_sport.Abonnements.Domain.DateCustom;

final class RenouvellerLesAbonnementsAutomatiquement {

    private final AbonnementRepository abonnementRepository;

    RenouvellerLesAbonnementsAutomatiquement(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    AbonnementsRenouvellésAutomatiquement handle(final DateCustom àPartirDe) {

        var abonnementsFinisAPartirDe = abonnementRepository.abonnementsFinisAPartirDe(àPartirDe);

        for (Abonnement abonnement : abonnementsFinisAPartirDe) {
            abonnement.renouveller();
        }

        abonnementRepository.storeAll(abonnementsFinisAPartirDe);

        return new AbonnementsRenouvellésAutomatiquement();
    }
}
