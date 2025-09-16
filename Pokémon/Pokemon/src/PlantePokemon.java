public class PlantePokemon extends Pokemon {
    public PlantePokemon(int numeroNational, String nom, int niveau, int hp,
                         int attaque, int defense, int attaqueSpeciale, int defenseSpeciale, int vitesse) {
        super(numeroNational, nom, "Plante", niveau, hp, attaque, defense, attaqueSpeciale, defenseSpeciale, vitesse);
    }

    @Override
    public void attaquer(Pokemon adversaire) {
        int puissance = 50;  // 固定威力
        boolean special = true;  // 使用特殊攻击

        int degats = calculerDommage(adversaire, puissance, special);
        adversaire.setHp(Math.max(adversaire.getHp() - degats, 0));

        System.out.println(getNom() + " 使用草系攻击！");
        if (getType().equals("Plante") && adversaire.getType().equals("Eau"))
            System.out.println("超级有效！");
        else if (getType().equals("Plante") && adversaire.getType().equals("Feu"))
            System.out.println("效果不佳...");
        System.out.println(adversaire.getNom() + " 失去 " + degats + " HP, 现在 HP: " + adversaire.getHp());
        System.out.println();
    }
}
