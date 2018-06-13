package fr.octo.craft.SalleDeSport.Abonnement.Domain;

final class Prix {

    private final double prix;

    private Prix(double prix) {
        this.prix = prix;
    }

    static Prix nouveau(double prix) {
        return new Prix(prix);
    }

    double prix() {
        return prix;
    }

    Prix réduction(Réduction réduction) {
        return new Prix(this.prix * réduction.taux());
    }
}
