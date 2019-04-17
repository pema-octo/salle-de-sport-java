package fr.octo.salle_de_sport.Abonnements.UseCases;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementSouscrit;
import fr.octo.salle_de_sport.Abonnements.Domain.DateCustom;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéId;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepository;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepositoryException;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepository;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepositoryException;

final class SouscrireAUnAbonnement {

    private final AbonnéRepository abonnéRepository;
    private final FormuleRepository formuleRepository;
    private final AbonnementRepository abonnementRepository;

    SouscrireAUnAbonnement(AbonnéRepository abonnéRepository, FormuleRepository formuleRepository, AbonnementRepository abonnementRepository) {
        this.abonnéRepository = abonnéRepository;
        this.formuleRepository = formuleRepository;
        this.abonnementRepository = abonnementRepository;
    }

    public AbonnementSouscrit handle(final AbonnéId abonnéId, final FormuleId formuleId, final DateCustom dateDeDébut) throws AbonnéRepositoryException, FormuleRepositoryException {

        var abonné = abonnéRepository.get(abonnéId);
        var formule = formuleRepository.get(formuleId);

        Abonnement abonnement = new Abonnement(
            abonné,
            formule,
            dateDeDébut
        );

        abonnementRepository.store(abonnement);

        return new AbonnementSouscrit(
            abonné.id(),
            formule.id(),
            abonnement.id()
        );
    }
}
