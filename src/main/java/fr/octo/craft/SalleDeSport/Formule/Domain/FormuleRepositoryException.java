package fr.octo.craft.SalleDeSport.Formule.Domain;

public final class FormuleRepositoryException extends Exception {

    private FormuleRepositoryException(String message) {
        super(message);
    }

    public static FormuleRepositoryException introuvable(FormuleId formuleId) {
        return new FormuleRepositoryException("Formule ["+formuleId+"] introuvable.");
    }
}
