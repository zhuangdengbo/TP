public class MainInheritance {
    public static void main(String[] args) {
        Carre carre = new Carre(4);
        Cube cube = new Cube(4);
        Hypercube hypercube = new Hypercube(4);

        System.out.println("=== Carré ===");
        System.out.println("Côté : " + carre.getCote());
        System.out.println("Aire : " + carre.aire());

        System.out.println("\n=== Cube ===");
        System.out.println("Côté : " + cube.getCote());
        System.out.println("Surface : " + cube.surface());
        System.out.println("Volume : " + cube.volume());

        System.out.println("\n=== Hypercube ===");
        System.out.println("Côté : " + hypercube.getCote());
        System.out.println("Hypervolume : " + hypercube.hypervolume());
        System.out.println("Bordure : " + hypercube.bordure());
    }
}