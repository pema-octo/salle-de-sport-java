package fr.octo.craft.SalleDeSport.Abonnement.Infrastructure.Database;

import fr.octo.craft.SalleDeSport.Abonnement.Domain.Abonnement;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementId;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementRepository;
import fr.octo.craft.SalleDeSport.Abonnement.Domain.AbonnementRepositoryException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
    public Collection<Abonnement> abonnementsEnCours(Date date) {

        Collection<Abonnement> abonnementsEnCours = new ArrayList<>();

        for (Abonnement abonnement : abonnements) {
            if (abonnement.estEnCours(date)) {
                abonnementsEnCours.add(abonnement);
            }
        }

        return abonnementsEnCours;
    }
}
