package fr.octo.salle_de_sport.Formules.Command;

import fr.octo.salle_de_sport.Formules.Domain.FormuleId;
import fr.octo.salle_de_sport.Formules.Domain.Prix;

final class ChangerLePrixDUneFormuleCommand {

    private final String formuleId;
    private final String nouveauPrix;

    ChangerLePrixDUneFormuleCommand(FormuleId formuleId, Prix nouveauPrix) {
        this.formuleId = formuleId.toString();
        this.nouveauPrix = nouveauPrix.toString();
    }

    FormuleId formuleId() {
        return new FormuleId(formuleId);
    }

    Prix nouveauPrix() {
        return new Prix(Double.valueOf(nouveauPrix));
    }
}
