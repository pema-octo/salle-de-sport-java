package fr.octo.salle_de_sport.Abonnés.Infrastructure.Database;

import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéId;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéNotFoundException;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepository;

import java.util.ArrayList;
import java.util.Collection;

public final class AbonnéInMemoryRepository implements AbonnéRepository {

    private final Collection<Abonné> abonnés = new ArrayList<>();

    @Override
    public void store(Abonné abonné) {
        abonnés.add(abonné);
    }

    @Override
    public Abonné get(AbonnéId abonnéId) throws AbonnéNotFoundException {
        for (Abonné abonné : abonnés) {
            if (abonné.id().equals(abonnéId)) {
                return abonné;
            }
        }

        throw AbonnéNotFoundException.introuvable(abonnéId);
    }
}
