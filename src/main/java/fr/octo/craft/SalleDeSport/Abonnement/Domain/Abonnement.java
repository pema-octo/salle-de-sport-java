package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;
import fr.octo.craft.SalleDeSport.Formule.Domain.DuréeFormule;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;

import java.util.Date;

public final class Abonnement {

    private final AbonnementId id;

    private final AdhérentId adhérentId;

    private final FormuleId formuleId;
    private final DuréeFormule duréeFormule;
    private final String nomFormule;

    private final Période période;
    private final double prix;

    public Abonnement(Adhérent adhérent, Formule formule, Date dateSouscription) {

        this.id = AbonnementId.generate();

        this.adhérentId = adhérent.id();

        this.formuleId = formule.id();
        this.duréeFormule = formule.durée();
        this.nomFormule = formule.nom();

        this.période = new Période(
            dateSouscription,
            formule.durée().nbMois()
        );

        this.prix = Réduction.pourAbonnement(adhérent, formule).appliquer(formule.prixDeBase());
    }

    public AbonnementId id() {
        return id;
    }

    public String nomFormule() {
        return nomFormule;
    }

    double prix() {
        return prix;
    }

    public boolean estEnCours(Date date) {
        return période.contient(date);
    }

    public double restantDu() {
        return prix;
    }
}
