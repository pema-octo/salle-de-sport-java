package fr.octo.craft.salle_de_sport.Formule.Domain;

public final class FormuleCréée {

    private final String formuleId;

    public FormuleCréée(FormuleId formuleId) {
        this.formuleId = formuleId.toString();
    }

    public FormuleId formuleId() {
        return FormuleId.fromString(formuleId);
    }
}
