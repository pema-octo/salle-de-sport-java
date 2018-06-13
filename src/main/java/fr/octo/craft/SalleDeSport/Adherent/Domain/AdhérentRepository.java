package fr.octo.craft.SalleDeSport.Adherent.Domain;

public interface AdhérentRepository {

    void store(Adhérent adhérent);

    Adhérent get(AdhérentId adhérentId) throws AdhérentRepositoryException;
}
