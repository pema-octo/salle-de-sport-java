package fr.octo.craft.SalleDeSport.Adherent.Domain;

public interface Mailer {

    void sendEmail(String email, String message);
}
