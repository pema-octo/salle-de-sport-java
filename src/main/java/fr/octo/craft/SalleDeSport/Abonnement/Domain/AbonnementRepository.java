package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import java.util.Collection;
import java.util.Date;

public interface AbonnementRepository {

    void store(Abonnement abonnement);

    Abonnement get(AbonnementId abonnementId) throws AbonnementRepositoryException;

    Collection<Abonnement> abonnementsEnCours(Date date);
}
