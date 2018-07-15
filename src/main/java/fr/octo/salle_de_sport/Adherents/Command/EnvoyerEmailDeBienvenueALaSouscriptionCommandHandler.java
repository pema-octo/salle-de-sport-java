package fr.octo.salle_de_sport.Adherents.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepositoryException;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementSouscrit;
import fr.octo.salle_de_sport.Adherents.Domain.*;

final class EnvoyerEmailDeBienvenueALaSouscriptionCommandHandler {

    private final AdhérentRepository adhérentRepository;
    private final AbonnementRepository abonnementRepository;
    private final Mailer mailer;

    EnvoyerEmailDeBienvenueALaSouscriptionCommandHandler(AdhérentRepository adhérentRepository, AbonnementRepository abonnementRepository, Mailer mailer) {
        this.adhérentRepository = adhérentRepository;
        this.abonnementRepository = abonnementRepository;
        this.mailer = mailer;
    }

    EmailDeBienvenueALaSouscriptionEnvoyé handle(AbonnementSouscrit event) throws AdhérentRepositoryException, AbonnementRepositoryException {

        Adhérent adhérent = adhérentRepository.get(event.adhérentId());
        Abonnement abonnement = abonnementRepository.get(event.abonnementId());

        mailer.sendEmail(
            adhérent.email(),
            "Bienvenu(e) chez CraftGym "+adhérent.prénom()+", profite bien de ton abonnement "+abonnement.descriptionFormuleChoisie()+"."
        );

        return new EmailDeBienvenueALaSouscriptionEnvoyé(
            adhérent.email(),
            abonnement
        );
    }
}
