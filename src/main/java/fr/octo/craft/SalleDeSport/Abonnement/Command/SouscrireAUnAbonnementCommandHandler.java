package fr.octo.craft.SalleDeSport.Abonnement.Command;

import fr.octo.craft.SalleDeSport.Abonnement.Domain.Abonnement;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementId;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementRepository;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementSouscrit;
import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentRepository;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentRepositoryException;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleRepository;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleRepositoryException;

import java.text.ParseException;
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

    public AbonnementSouscrit handle(SouscrireAUnAbonnementCommand command) throws AdhérentRepositoryException, FormuleRepositoryException, ParseException {

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
