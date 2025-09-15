class Hypercube extends Cube {
    public Hypercube(double cote) {
        super(cote);
    }

    public double hypervolume() {
        return Math.pow(getCote(), 4);
    }

    public double bordure() {
        return 8 * Math.pow(getCote(), 3);
    }
}
