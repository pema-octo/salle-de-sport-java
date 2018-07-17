package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.Prix;

import java.util.ArrayList;
import java.util.List;

public final class Abonnement {

    private final AbonnementId id;
    private final FormuleChoisie formuleChoisie;
    private final Prix prix;
    private final List<Période> périodes = new ArrayList<>();

    public Abonnement(Abonné abonné, Formule formule, MaDate date) {
        this(
            new AbonnementId(),
            abonné,
            formule,
            date
        );
    }

    public Abonnement(AbonnementId abonnementId, Abonné abonné, Formule formule, MaDate date) {

        this.id = abonnementId;

        this.formuleChoisie = new FormuleChoisie(formule);

        Réduction réduction = new Réduction(abonné, formule);
        this.prix = formule.prixDeBase().aprèsRéduction(réduction);

        this.périodes.add(
            new Période(date, formule.duréeEnMois())
        );
    }

    public AbonnementId id() {
        return id;
    }

    public String descriptionFormuleChoisie() {
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
