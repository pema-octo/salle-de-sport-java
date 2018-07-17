package fr.octo.salle_de_sport.Abonnés.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepositoryException;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementSouscrit;
import fr.octo.salle_de_sport.Abonnés.Domain.*;

final class EnvoyerEmailDeBienvenueALaSouscriptionCommandHandler {

    private final AbonnéRepository abonnéRepository;
    private final AbonnementRepository abonnementRepository;
    private final Mailer mailer;

    EnvoyerEmailDeBienvenueALaSouscriptionCommandHandler(AbonnéRepository abonnéRepository, AbonnementRepository abonnementRepository, Mailer mailer) {
        this.abonnéRepository = abonnéRepository;
        this.abonnementRepository = abonnementRepository;
        this.mailer = mailer;
    }

    EmailDeBienvenueALaSouscriptionEnvoyé handle(AbonnementSouscrit event) throws AbonnéRepositoryException, AbonnementRepositoryException {

        Abonné abonné = abonnéRepository.get(event.abonnéId);
        Abonnement abonnement = abonnementRepository.get(event.abonnementId);

        mailer.sendEmail(
            abonné.email(),
            "Bienvenu(e) chez CraftGym "+ abonné.prénom()+", profite bien de ton abonnement "+abonnement.descriptionFormuleChoisie()+"."
        );

        return new EmailDeBienvenueALaSouscriptionEnvoyé(
            abonné.email(),
            abonnement
        );
    }
}
