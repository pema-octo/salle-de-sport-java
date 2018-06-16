package fr.octo.craft.SalleDeSport.Formule.Command;

import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;
import fr.octo.craft.SalleDeSport.Formule.Domain.Prix;

final class ChangerLePrixDUneFormuleCommand {

    private final String formuleId;
    private final String nouveauPrix;

    ChangerLePrixDUneFormuleCommand(FormuleId formuleId, Prix nouveauPrix) {
        this.formuleId = formuleId.toString();
        this.nouveauPrix = nouveauPrix.toString();
    }

    FormuleId formuleId() {
        return FormuleId.fromString(formuleId);
    }

    Prix nouveauPrix() {
        return new Prix(Double.valueOf(nouveauPrix));
    }
}
