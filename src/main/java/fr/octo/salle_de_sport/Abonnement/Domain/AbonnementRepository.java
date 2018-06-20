package fr.octo.salle_de_sport.Abonnement.Domain;

import java.util.Collection;

public interface AbonnementRepository {

    void store(Abonnement abonnement);

    void storeAll(Collection<Abonnement> abonnements);

    Abonnement get(AbonnementId abonnementId) throws AbonnementRepositoryException;

    Collection<Abonnement> abonnementsEnCours(MaDate date);

    Collection<Abonnement> abonnementsFinisAPartirDe(MaDate date);
}
