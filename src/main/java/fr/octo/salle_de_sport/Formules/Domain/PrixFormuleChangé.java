package fr.octo.salle_de_sport.Formules.Domain;

public final class PrixFormuleChangé {

    public final FormuleId formuleId;
    public final Prix ancienPrix;
    public final Prix nouveauPrix;

    public PrixFormuleChangé(final Formule formule, final Prix ancienPrix, final Prix nouveauPrix) {
        this.formuleId = formule.id();
        this.ancienPrix = ancienPrix;
        this.nouveauPrix = nouveauPrix;
    }
}
