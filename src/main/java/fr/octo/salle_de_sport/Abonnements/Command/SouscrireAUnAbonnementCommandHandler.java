package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementSouscrit;
import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepository;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepositoryException;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepository;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepositoryException;

final class SouscrireAUnAbonnementCommandHandler {

    private final AbonnéRepository abonnéRepository;
    private final FormuleRepository formuleRepository;
    private final AbonnementRepository abonnementRepository;

    SouscrireAUnAbonnementCommandHandler(AbonnéRepository abonnéRepository, FormuleRepository formuleRepository, AbonnementRepository abonnementRepository) {
        this.abonnéRepository = abonnéRepository;
        this.formuleRepository = formuleRepository;
        this.abonnementRepository = abonnementRepository;
    }

    public AbonnementSouscrit handle(SouscrireAUnAbonnementCommand command) throws AbonnéRepositoryException, FormuleRepositoryException {

        Abonné abonné = abonnéRepository.get(command.abonnéId);
        Formule formule = formuleRepository.get(command.formuleId);

        Abonnement abonnement = new Abonnement(
            abonné,
            formule,
            command.date
        );

        abonnementRepository.store(abonnement);

        return new AbonnementSouscrit(abonné, formule, abonnement);
    }
}
