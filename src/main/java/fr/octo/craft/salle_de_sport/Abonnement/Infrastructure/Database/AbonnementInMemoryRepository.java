package fr.octo.craft.salle_de_sport.Abonnement.Infrastructure.Database;

import fr.octo.craft.salle_de_sport.Abonnement.Domain.*;

import java.util.ArrayList;
import java.util.Collection;

public final class AbonnementInMemoryRepository implements AbonnementRepository {

    private final Collection<Abonnement> abonnements = new ArrayList<>();

    @Override
    public void store(Abonnement abonnement) {

        abonnements.add(abonnement);
    }

    @Override
    public Abonnement get(AbonnementId abonnementId) throws AbonnementRepositoryException {

        for (Abonnement abonnement : abonnements) {
            if (abonnement.id().equals(abonnementId)) {
                return abonnement;
            }
        }

        throw AbonnementRepositoryException.introuvable(abonnementId);
    }

    @Override
    public Collection<Abonnement> abonnementsEnCours(MaDate date) {

        Collection<Abonnement> abonnementsEnCours = new ArrayList<>();

        for (Abonnement abonnement : abonnements) {
            if (abonnement.estEnCours(date)) {
                abonnementsEnCours.add(abonnement);
            }
        }

        return abonnementsEnCours;
    }
}
