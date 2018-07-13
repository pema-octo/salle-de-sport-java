package fr.octo.salle_de_sport.Abonnements.Domain;

import java.time.Period;

final class Période {

    private static final String AU = " au ";

    private final MaDate dateDeDébut;
    private final MaDate dateDeFin;

    Période(MaDate dateDeDébut, int nbMois) {
        this.dateDeDébut = dateDeDébut;
        this.dateDeFin = dateDeDébut.plusXMois(nbMois).jourDAvant();
    }

    private Période(MaDate dateDeDébut, MaDate dateDeFin) {
        this.dateDeDébut = dateDeDébut;
        this.dateDeFin = dateDeFin;
    }

    public static Période fromString(String période) {

        String[] dates = période.split(AU);

        return new Période(
            MaDate.fromString(dates[0]),
            MaDate.fromString(dates[1])
        );
    }

    MaDate dateDeDébut() {
        return dateDeDébut;
    }

    Boolean contient(MaDate date) {
        return date.après(dateDeDébut) && date.avant(dateDeFin);
    }

    Boolean avantLaDate(MaDate date) {
        return date.après(dateDeFin);
    }

    Période suivante() {
        int nbMoisPériodeCourante = Period.between(dateDeDébut.toLocalDate(), dateDeFin.jourSuivant().toLocalDate()).getMonths();

        return new Période(
            dateDeFin.jourSuivant(),
            nbMoisPériodeCourante
        );
    }

    @Override
    public String toString() {
        return dateDeDébut + AU + dateDeFin;
    }
}
