package fr.octo.craft.salle_de_sport.Adherent.Domain;

public interface Mailer {

    void sendEmail(String email, String message);
}
