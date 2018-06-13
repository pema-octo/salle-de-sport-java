package fr.octo.craft.SalleDeSport.Formule.Command;

import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;

final class ChangerLePrixDUneFormuleCommand {

    final FormuleId formuleId;
    final double nouveauPrix;

    ChangerLePrixDUneFormuleCommand(FormuleId formuleId, double nouveauPrix) {
        this.formuleId = formuleId;
        this.nouveauPrix = nouveauPrix;
    }
}
