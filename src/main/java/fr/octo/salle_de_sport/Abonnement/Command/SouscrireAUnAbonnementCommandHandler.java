package fr.octo.salle_de_sport.Abonnement.Command;

import fr.octo.salle_de_sport.Abonnement.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnement.Domain.AbonnementId;
import fr.octo.salle_de_sport.Abonnement.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnement.Domain.AbonnementSouscrit;
import fr.octo.salle_de_sport.Adherent.Domain.Adhérent;
import fr.octo.salle_de_sport.Adherent.Domain.AdhérentRepository;
import fr.octo.salle_de_sport.Adherent.Domain.AdhérentRepositoryException;
import fr.octo.salle_de_sport.Formule.Domain.Formule;
import fr.octo.salle_de_sport.Formule.Domain.FormuleRepository;
import fr.octo.salle_de_sport.Formule.Domain.FormuleRepositoryException;

import java.util.UUID;

final class SouscrireAUnAbonnementCommandHandler {

    private final AdhérentRepository adhérentRepository;
    private final FormuleRepository formuleRepository;
    private final AbonnementRepository abonnementRepository;

    SouscrireAUnAbonnementCommandHandler(AdhérentRepository adhérentRepository, FormuleRepository formuleRepository, AbonnementRepository abonnementRepository) {
        this.adhérentRepository = adhérentRepository;
        this.formuleRepository = formuleRepository;
        this.abonnementRepository = abonnementRepository;
    }

    public String handles() {
        return SouscrireAUnAbonnementCommand.class.getCanonicalName();
    }

    public AbonnementSouscrit handle(SouscrireAUnAbonnementCommand command) throws AdhérentRepositoryException, FormuleRepositoryException {

        Adhérent adhérent = adhérentRepository.get(command.adhérentId());
        Formule formule = formuleRepository.get(command.formuleId());

        Abonnement abonnement = new Abonnement(
            AbonnementId.fromString(UUID.randomUUID().toString()),
            adhérent,
            formule,
            command.date()
        );

        abonnementRepository.store(abonnement);

        return new AbonnementSouscrit(adhérent, formule, abonnement);
    }
}
