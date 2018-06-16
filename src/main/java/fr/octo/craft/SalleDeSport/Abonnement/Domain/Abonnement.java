package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;
import fr.octo.craft.SalleDeSport.Formule.Domain.DuréeFormule;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;

public final class Abonnement {

    private final AbonnementId id;

    private final AdhérentId adhérentId;

    private final FormuleId formuleId;
    private final DuréeFormule duréeFormule;
    private final String nomFormule;

    private final Période période;
    private final Double prix;

    public Abonnement(AbonnementId abonnementId, Adhérent adhérent, Formule formule, MaDate date) {

        this.id = abonnementId;

        this.adhérentId = adhérent.id();

        this.formuleId = formule.id();
        this.duréeFormule = formule.durée();
        this.nomFormule = formule.nom();

        this.période = new Période(
            date,
            formule.duréeEnMois()
        );

        Réduction réduction = Réduction.pourAbonnement(adhérent, formule);
        this.prix = formule.prixDeBase().appliqueRéduction(réduction).montant();
    }

    public AbonnementId id() {
        return id;
    }

    public String nomFormule() {
        return nomFormule;
    }

    Double prix() {
        return prix;
    }

    public MaDate dateDeSouscription() {
        return période.dateDeDébut();
    }

    public Boolean estEnCours(MaDate date) {
        return période.contient(date);
    }

    public Double restantDu() {
        return prix;
    }
}
