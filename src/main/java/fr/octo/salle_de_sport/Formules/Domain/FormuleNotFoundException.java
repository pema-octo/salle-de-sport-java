package fr.octo.salle_de_sport.Formules.Domain;

public final class FormuleNotFoundException extends Exception {

    private FormuleNotFoundException(String message) {
        super(message);
    }

    public static FormuleNotFoundException introuvable(final FormuleId formuleId) {
        return new FormuleNotFoundException("Formule [" + formuleId + "] introuvable.");
    }
}
