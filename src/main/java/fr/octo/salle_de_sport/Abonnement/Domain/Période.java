package fr.octo.salle_de_sport.Abonnement.Domain;

import java.util.Calendar;

final class Période {

    private final MaDate dateDeDébut;
    private final MaDate dateDeFin;

    Période(MaDate dateDeDébut, int nbMois) {
        this.dateDeDébut = dateDeDébut;

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, nbMois);
        this.dateDeFin = new MaDate(cal.getTime());
    }

    MaDate dateDeDébut() {
        return dateDeDébut;
    }

    MaDate dateDeFin() {
        return dateDeFin;
    }

    Boolean contient(MaDate date) {
        return date.après(dateDeDébut) && date.avant(dateDeFin);
    }

    @Override
    public String toString() {
        return "Période{" + "dateDeDébut=" + dateDeDébut + ", dateDeFin=" + dateDeFin + '}';
    }
}
