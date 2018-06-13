package fr.octo.craft.SalleDeSport.Formule.Domain;

public interface FormuleRepository {

    void store(Formule formule);

    Formule get(FormuleId adhérentId) throws FormuleRepositoryException;
}
