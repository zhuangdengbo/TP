class CubeN extends ShapeN{
    // TODO: Constructeur
    public CubeN(double cote) {
        super(cote,3);
    }
    // TODO: Override calculateBoundary() -> 6 * cote^2
    @Override
    public double calculateBoundary() {
        return 6 * Math.pow(getCote(), 2); // Surface totale du cube
    }

}
