package fr.octo.salle_de_sport.Formule.Domain;

public final class FormuleCréée {

    private final String formuleId;

    public FormuleCréée(Formule formule) {
        this.formuleId = formule.id().toString();
    }

    public FormuleId formuleId() {
        return FormuleId.fromString(formuleId);
    }
}
