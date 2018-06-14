package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import java.util.Calendar;
import java.util.Date;

final class Période {

    private final Date dateDeDébut;
    private final Date dateDeFin;

    Période(Date dateDeDébut, int nbMois) {
        this.dateDeDébut = dateDeDébut;

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, nbMois);
        this.dateDeFin = cal.getTime();
    }

    Boolean contient(Date date) {
        return date.after(dateDeDébut) && date.before(dateDeFin);
    }

    @Override
    public String toString() {
        return "Période{" +
            "dateDeDébut=" + dateDeDébut +
            ", dateDeFin=" + dateDeFin +
            '}';
    }
}
