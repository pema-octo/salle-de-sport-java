package fr.octo.salle_de_sport.Adherent.Infrastructure.Database;

import fr.octo.salle_de_sport.Adherent.Domain.Adhérent;
import fr.octo.salle_de_sport.Adherent.Domain.AdhérentId;
import fr.octo.salle_de_sport.Adherent.Domain.AdhérentRepository;
import fr.octo.salle_de_sport.Adherent.Domain.AdhérentRepositoryException;

import java.util.ArrayList;
import java.util.Collection;

public final class AdhérentInMemoryRepository implements AdhérentRepository {

    private final Collection<Adhérent> adhérents = new ArrayList<>();

    @Override
    public void store(Adhérent adhérent) {
        adhérents.add(adhérent);
    }

    @Override
    public Adhérent get(AdhérentId adhérentId) throws AdhérentRepositoryException {
        for (Adhérent adhérent : adhérents) {
            if (adhérent.id().equals(adhérentId)) {
                return adhérent;
            }
        }

        throw AdhérentRepositoryException.introuvable(adhérentId);
    }
}
