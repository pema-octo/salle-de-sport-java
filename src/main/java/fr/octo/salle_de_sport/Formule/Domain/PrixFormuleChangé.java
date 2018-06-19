package fr.octo.salle_de_sport.Formule.Domain;

public final class PrixFormuleChangé {

    private final String formuleId;
    private final String ancienPrix;
    private final String nouveauPrix;

    public PrixFormuleChangé(Formule formule, Prix ancienPrix, Prix nouveauPrix) {
        this.formuleId = formule.id().toString();
        this.ancienPrix = String.valueOf(ancienPrix.montant());
        this.nouveauPrix = String.valueOf(nouveauPrix.montant());
    }

    public FormuleId formuleId() {
        return FormuleId.fromString(formuleId);
    }

    public Prix ancienPrix() {
        return new Prix(Double.valueOf(ancienPrix));
    }

    public Prix nouveauPrix() {
        return new Prix(Double.valueOf(nouveauPrix));
    }
}
