package fr.octo.craft.SalleDeSport.Formule.Domain;

public final class PrixFormuleChangé {

    public final FormuleId formuleId;
    public final double ancienPrix;
    public final double nouveauPrix;

    public PrixFormuleChangé(FormuleId formuleId, double ancienPrix, double nouveauPrix) {
        this.formuleId = formuleId;
        this.ancienPrix = ancienPrix;
        this.nouveauPrix = nouveauPrix;
    }
}
