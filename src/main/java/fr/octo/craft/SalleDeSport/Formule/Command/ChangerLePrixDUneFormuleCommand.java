package fr.octo.craft.SalleDeSport.Formule.Command;

import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;

final class ChangerLePrixDUneFormuleCommand {

    final FormuleId formuleId;
    final Double nouveauPrix;

    ChangerLePrixDUneFormuleCommand(FormuleId formuleId, Double nouveauPrix) {
        this.formuleId = formuleId;
        this.nouveauPrix = nouveauPrix;
    }
}
