package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Adherents.Domain.Adhérent;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.Prix;

import java.util.ArrayList;
import java.util.List;

public final class Abonnement {

    private final AbonnementId id;
    private final FormuleChoisie formuleChoisie;
    private final List<Période> périodes = new ArrayList<>();
    private final Prix prix;

    public Abonnement(AbonnementId abonnementId, Adhérent adhérent, Formule formule, MaDate date) {

        this.id = abonnementId;

        this.formuleChoisie = new FormuleChoisie(formule);

        this.périodes.add(
            new Période(date, formule.duréeEnMois())
        );

        Réduction réduction = new Réduction(adhérent, formule);
        this.prix = formule.prixDeBase().appliqueRéduction(réduction);
    }

    public AbonnementId id() {
        return id;
    }

    public String descriptionFormule() {
        return formuleChoisie.descriptionFormule;
    }

    Prix prix() {
        return prix;
    }

    public Double restantDu() {
        return Double.valueOf(prix.toString());
    }

    private Période dernièrePériode() {
        return périodes.get(périodes.size() - 1);
    }

    public Boolean estEnCours(MaDate date) {
        return dernièrePériode().contient(date);
    }

    public Boolean seraFiniLe(MaDate date) {
        return dernièrePériode().avantLaDate(date);
    }

    public void renouveller() {
        périodes.add(
            dernièrePériode().suivante()
        );
    }
}
