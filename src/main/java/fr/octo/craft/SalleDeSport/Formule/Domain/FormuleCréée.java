package fr.octo.craft.SalleDeSport.Formule.Domain;

public final class FormuleCréée {

    private final FormuleId formuleId;

    public FormuleCréée(FormuleId formuleId) {
        this.formuleId = formuleId;
    }

    public FormuleId formuleId() {
        return formuleId;
    }
}
