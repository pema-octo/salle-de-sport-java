package fr.octo.craft.SalleDeSport.Adherent.Command;

import fr.octo.craft.SalleDeSport.Abonnement.Domain.Abonnement;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementRepository;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementRepositoryException;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementSouscrit;
import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentRepository;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentRepositoryException;
import fr.octo.craft.SalleDeSport.Adherent.Domain.Mailer;

final class EnvoyerEmailDeBienvenueALaSouscriptionCommandHandler {

    private final AdhérentRepository adhérentRepository;
    private final AbonnementRepository abonnementRepository;
    private final Mailer mailer;

    EnvoyerEmailDeBienvenueALaSouscriptionCommandHandler(AdhérentRepository adhérentRepository, AbonnementRepository abonnementRepository, Mailer mailer) {
        this.adhérentRepository = adhérentRepository;
        this.abonnementRepository = abonnementRepository;
        this.mailer = mailer;
    }

    void handle(AbonnementSouscrit event) throws AdhérentRepositoryException, AbonnementRepositoryException {

        Adhérent adhérent = adhérentRepository.get(event.adhérentId());
        Abonnement abonnement = abonnementRepository.get(event.abonnementId());

        mailer.sendEmail(
            adhérent.email(),
            "Bienvenu chez CraftGym "+adhérent.prénom()+", profite bien de ton abonnement "+abonnement.nomFormule()
        );
    }
}
