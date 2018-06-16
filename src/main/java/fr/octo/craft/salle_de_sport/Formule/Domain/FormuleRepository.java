package fr.octo.craft.salle_de_sport.Formule.Domain;

public interface FormuleRepository {

    void store(Formule formule);

    Formule get(FormuleId adhérentId) throws FormuleRepositoryException;
}
