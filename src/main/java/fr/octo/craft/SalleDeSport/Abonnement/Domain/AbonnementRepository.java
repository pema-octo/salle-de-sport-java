package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import java.util.Collection;

public interface AbonnementRepository {

    void store(Abonnement abonnement);

    Abonnement get(AbonnementId abonnementId) throws AbonnementRepositoryException;

    Collection<Abonnement> abonnementsEnCours(MaDate date);
}
