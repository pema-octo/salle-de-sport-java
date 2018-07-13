package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementsRenouvellésAutomatiquement;

import java.util.Collection;

final class RenouvellerLesAbonnementsAutomatiquementCommandHandler {

    private final AbonnementRepository abonnementRepository;

    RenouvellerLesAbonnementsAutomatiquementCommandHandler(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    AbonnementsRenouvellésAutomatiquement handle(RenouvellerLesAbonnementsAutomatiquementCommand command) {

        Collection<Abonnement> abonnementsFinisAPartirDe = abonnementRepository.abonnementsFinisAPartirDe(command.date);

        for (Abonnement abonnement : abonnementsFinisAPartirDe) {
            abonnement.renouveller();
        }

        abonnementRepository.storeAll(abonnementsFinisAPartirDe);

        return new AbonnementsRenouvellésAutomatiquement();
    }
}
