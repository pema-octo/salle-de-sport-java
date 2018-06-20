package fr.octo.salle_de_sport.Abonnement.Domain;

import fr.octo.salle_de_sport.Adherent.Domain.Adhérent;
import fr.octo.salle_de_sport.Formule.Domain.Formule;
import fr.octo.salle_de_sport.Formule.Domain.Prix;

public final class Abonnement {

    private final String id;

    private final String adhérentId;

    private final String formuleId;
    private final String descriptionFormule;

    private String période;
    private final Double prix;

    public Abonnement(AbonnementId abonnementId, Adhérent adhérent, Formule formule, MaDate date) {

        this.id = abonnementId.toString();

        this.adhérentId = adhérent.id().toString();

        this.formuleId = formule.id().toString();
        this.descriptionFormule = formule.description();

        this.période = new Période(date, formule.duréeEnMois()).toString();

        Réduction réduction = Réduction.pourAbonnement(adhérent, formule);
        this.prix = formule.prixDeBase().appliqueRéduction(réduction).montant();
    }

    public AbonnementId id() {
        return AbonnementId.fromString(id);
    }

    MaDate dateDeSouscription() {
        return Période.fromString(période).dateDeDébut();
    }

    public String descriptionFormule() {
        return descriptionFormule;
    }

    Prix prix() {
        return new Prix(prix);
    }

    public Double restantDu() {
        return prix;
    }

    public Boolean estEnCours(MaDate date) {
        return Période.fromString(période).contient(date);
    }

    public Boolean seraFiniLe(MaDate date) {
        return Période.fromString(période).avantLaDate(date);
    }

    public void renouveller() {
        période = Période.fromString(période).suivante().toString();
    }
}
