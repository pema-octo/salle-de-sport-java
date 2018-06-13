package fr.octo.craft.SalleDeSport.Abonnement.Command;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;

import java.util.Date;

final class SouscrireAUnAbonnementCommand {

    final Adhérent adhérent;
    final Formule formule;
    final Date date;

    SouscrireAUnAbonnementCommand(Adhérent adhérent, Formule formule, Date date) {
        this.adhérent = adhérent;
        this.formule = formule;
        this.date = date;
    }
}
