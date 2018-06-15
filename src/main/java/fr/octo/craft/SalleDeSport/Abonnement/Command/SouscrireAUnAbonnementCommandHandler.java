package fr.octo.craft.SalleDeSport.Abonnement.Command;

import fr.octo.craft.SalleDeSport.Abonnement.Domain.Abonnement;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementId;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementRepository;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementSouscrit;

import java.util.UUID;

final class SouscrireAUnAbonnementCommandHandler {

    private final AbonnementRepository abonnementRepository;

    public SouscrireAUnAbonnementCommandHandler(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    public AbonnementSouscrit handle(SouscrireAUnAbonnementCommand command) {
        Abonnement abonnement = new Abonnement(
            AbonnementId.fromString(UUID.randomUUID().toString()),
            command.adhérent,
            command.formule,
            command.date
        );

        abonnementRepository.store(abonnement);

        return new AbonnementSouscrit(
            command.adhérent.id(),
            abonnement.id()
        );
    }
}
