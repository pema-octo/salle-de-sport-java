package fr.octo.salle_de_sport.Adherents.Domain;

public interface AdhérentRepository {

    void store(Adhérent adhérent);

    Adhérent get(AdhérentId adhérentId) throws AdhérentRepositoryException;
}
