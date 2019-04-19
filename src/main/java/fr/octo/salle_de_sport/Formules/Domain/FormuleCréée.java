package fr.octo.salle_de_sport.Formules.Domain;

public final class FormuleCréée {

    public final FormuleId formuleId;

    public FormuleCréée(final Formule formule) {
        this.formuleId = formule.id();
    }
}
