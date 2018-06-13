package fr.octo.craft.SalleDeSport.Adherent.Infrastructure.Database;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentRepositoryException;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentRepository;

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
