package fr.octo.craft.SalleDeSport.Formule.Domain;

public final class PrixFormuleChangé {

    public final FormuleId formuleId;
    public final Prix ancienPrix;
    public final Prix nouveauPrix;

    public PrixFormuleChangé(FormuleId formuleId, Prix ancienPrix, Prix nouveauPrix) {
        this.formuleId = formuleId;
        this.ancienPrix = ancienPrix;
        this.nouveauPrix = nouveauPrix;
    }
}
