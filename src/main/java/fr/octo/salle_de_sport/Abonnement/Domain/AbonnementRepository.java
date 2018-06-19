package fr.octo.salle_de_sport.Abonnement.Domain;

import java.util.Collection;

public interface AbonnementRepository {

    void store(Abonnement abonnement);

    Abonnement get(AbonnementId abonnementId) throws AbonnementRepositoryException;

    Collection<Abonnement> abonnementsEnCours(MaDate date);
}
