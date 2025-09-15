class HypercubeN extends ShapeN{
    // TODO: Constructeur
    public HypercubeN(double cote) {
        super(cote,4);

    }

    // TODO: Override calculateBoundary() -> 8 * cote^3
    @Override
    public double calculateBoundary() {
        return 8 * Math.pow(getCote(), 3);
    }

}
