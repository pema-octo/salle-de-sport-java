package fr.octo.craft.salle_de_sport.Adherent.Domain;

public interface AdhérentRepository {

    void store(Adhérent adhérent);

    Adhérent get(AdhérentId adhérentId) throws AdhérentRepositoryException;
}
