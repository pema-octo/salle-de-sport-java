package fr.octo.salle_de_sport.Abonnés.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
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

    EmailDeBienvenueALaSouscriptionEnvoyé handle(final AbonnementSouscrit event) throws EmailDeBienvenueALaSouscriptionPasEnvoyéException {

        try {
            Abonné abonné = abonnéRepository.get(event.abonnéId);
            Abonnement abonnement = abonnementRepository.get(event.abonnementId);

            mailer.sendEmail(
                abonné.email(),
                "Bienvenu(e) chez CraftGym " + abonné.prénom() + ", profite bien de ton abonnement " + abonnement.descriptionFormuleChoisie() + "."
            );

            return new EmailDeBienvenueALaSouscriptionEnvoyé(
                abonné.email(),
                abonnement
            );
        } catch (AbonnéNotFoundException | AbonnementNotFoundException | EmailNotSendException e) {
            throw new EmailDeBienvenueALaSouscriptionPasEnvoyéException(e.getMessage());
        }
    }
}
