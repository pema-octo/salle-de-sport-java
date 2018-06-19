package fr.octo.salle_de_sport.Abonnement.Domain;

import fr.octo.salle_de_sport.Adherent.Domain.Adhérent;
import fr.octo.salle_de_sport.Formule.Domain.Formule;
import fr.octo.salle_de_sport.Formule.Domain.Prix;

public final class Abonnement {

    private final String id;

    private final String adhérentId;

    private final String formuleId;
    private final String descriptionFormule;

    private final Période période;
    private final Double prix;

    public Abonnement(AbonnementId abonnementId, Adhérent adhérent, Formule formule, MaDate date) {

        this.id = abonnementId.toString();

        this.adhérentId = adhérent.id().toString();

        this.formuleId = formule.id().toString();
        this.descriptionFormule = formule.description();

        this.période = new Période(date, formule.duréeEnMois());

        Réduction réduction = Réduction.pourAbonnement(adhérent, formule);
        this.prix = formule.prixDeBase().appliqueRéduction(réduction).montant();
    }

    public AbonnementId id() {
        return AbonnementId.fromString(id);
    }

    public String nomFormule() {
        return descriptionFormule;
    }

    Prix prix() {
        return new Prix(prix);
    }

    MaDate dateDeSouscription() {
        return période.dateDeDébut();
    }

    public Boolean estEnCours(MaDate date) {
        return période.contient(date);
    }

    public Double restantDu() {
        return prix;
    }
}
