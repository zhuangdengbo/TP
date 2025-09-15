class CarreN extends ShapeN {
    // TODO: Constructeur
    public CarreN(double cote) {
        super(cote,2);
    }

    // TODO: Override calculateBoundary() -> 4 * cote

    @Override
    public double calculateBoundary() {
        return 4 * getCote(); // Périmètre du carré
    }
}



