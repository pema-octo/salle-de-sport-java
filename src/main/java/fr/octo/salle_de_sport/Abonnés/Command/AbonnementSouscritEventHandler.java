package fr.octo.salle_de_sport.Abonnés.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementNotFoundException;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementSouscrit;
import fr.octo.salle_de_sport.Abonnés.Domain.*;

final class AbonnementSouscritEventHandler {

    private final AbonnéRepository abonnéRepository;
    private final AbonnementRepository abonnementRepository;
    private final Mailer mailer;

    AbonnementSouscritEventHandler(AbonnéRepository abonnéRepository, AbonnementRepository abonnementRepository, Mailer mailer) {
        this.abonnéRepository = abonnéRepository;
        this.abonnementRepository = abonnementRepository;
        this.mailer = mailer;
    }

    EmailDeBienvenueALaSouscriptionEnvoyé handle(final AbonnementSouscrit event) throws AbonnéNotFoundException, AbonnementNotFoundException, EmailNotSendException {

        var abonné = abonnéRepository.get(event.abonnéId);
        var abonnement = abonnementRepository.get(event.abonnementId);

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
