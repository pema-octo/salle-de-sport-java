package fr.octo.salle_de_sport.Adherent.Command;

import fr.octo.salle_de_sport.Abonnement.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnement.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnement.Domain.AbonnementRepositoryException;
import fr.octo.salle_de_sport.Abonnement.Domain.AbonnementSouscrit;
import fr.octo.salle_de_sport.Adherent.Domain.*;

final class EnvoyerEmailDeBienvenueALaSouscriptionCommandHandler {

    private final AdhérentRepository adhérentRepository;
    private final AbonnementRepository abonnementRepository;
    private final Mailer mailer;

    EnvoyerEmailDeBienvenueALaSouscriptionCommandHandler(AdhérentRepository adhérentRepository, AbonnementRepository abonnementRepository, Mailer mailer) {
        this.adhérentRepository = adhérentRepository;
        this.abonnementRepository = abonnementRepository;
        this.mailer = mailer;
    }

    public String handles() {
        return AbonnementSouscrit.class.getCanonicalName();
    }

    EmailDeBienvenueALaSouscriptionEnvoyé handle(AbonnementSouscrit event) throws AdhérentRepositoryException, AbonnementRepositoryException {

        Adhérent adhérent = adhérentRepository.get(event.adhérentId());
        Abonnement abonnement = abonnementRepository.get(event.abonnementId());

        mailer.sendEmail(
            adhérent.email(),
            "Bienvenu(e) chez CraftGym "+adhérent.prénom()+", profite bien de ton abonnement "+abonnement.nomFormule()+"."
        );

        return new EmailDeBienvenueALaSouscriptionEnvoyé(
            adhérent.email(),
            abonnement
        );
    }
}
