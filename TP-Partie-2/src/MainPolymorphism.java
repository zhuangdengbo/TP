
public class MainPolymorphism {
    public static void main(String[] args) {
        // TODO: Créer un tableau ou une liste de ShapeN
        // TODO: Ajouter CarreN, CubeN, HypercubeN
        ShapeN[] shapes = {
                new CarreN(5),
                new CubeN(4),
                new HypercubeN(3),
        };


        // TODO: Boucler et afficher cote, volume, bordure pour chaque forme

        for (ShapeN shape : shapes) {
            if (shape instanceof CarreN) {
                System.out.println("Carré : côté = " + shape.getCote() +
                        ", Aire = " + shape.calculateVolume() +
                        ", Bordure = " + shape.calculateBoundary());
            } else if (shape instanceof CubeN) {
                System.out.println("Cube : côté = " + shape.getCote() +
                        ", Volume = " + shape.calculateVolume() +
                        ", Surface = " + shape.calculateBoundary());
            } else if (shape instanceof HypercubeN) {
                System.out.println("Hypercube : côté = " + shape.getCote() +
                        ", Hypervolume = " + shape.calculateVolume() +
                        ", Bordure = " + shape.calculateBoundary());
            }
        }
    }
}