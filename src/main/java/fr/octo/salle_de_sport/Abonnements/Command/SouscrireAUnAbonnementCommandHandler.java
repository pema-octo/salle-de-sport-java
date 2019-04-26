package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementSouscrit;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéNotFoundException;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepository;
import fr.octo.salle_de_sport.Formules.Domain.FormuleNotFoundException;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepository;

final class SouscrireAUnAbonnementCommandHandler {

    private final AbonnéRepository abonnéRepository;
    private final FormuleRepository formuleRepository;
    private final AbonnementRepository abonnementRepository;

    SouscrireAUnAbonnementCommandHandler(AbonnéRepository abonnéRepository, FormuleRepository formuleRepository, AbonnementRepository abonnementRepository) {
        this.abonnéRepository = abonnéRepository;
        this.formuleRepository = formuleRepository;
        this.abonnementRepository = abonnementRepository;
    }

    public AbonnementSouscrit handle(final SouscrireAUnAbonnementCommand command) throws AbonnéNotFoundException, FormuleNotFoundException {

        var abonné = abonnéRepository.get(command.abonnéId);
        var formule = formuleRepository.get(command.formuleId);

        Abonnement abonnement = new Abonnement(
            abonné,
            formule,
            command.dateDeDébut
        );

        abonnementRepository.store(abonnement);

        return new AbonnementSouscrit(
            abonné,
            formule,
            abonnement
        );
    }
}
