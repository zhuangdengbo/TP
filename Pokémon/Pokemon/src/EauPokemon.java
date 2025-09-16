public class EauPokemon extends Pokemon {
    public EauPokemon(int numeroNational, String nom, int niveau, int hp,
                      int attaque, int defense, int attaqueSpeciale, int defenseSpeciale, int vitesse) {
        super(numeroNational, nom, "Eau", niveau, hp, attaque, defense, attaqueSpeciale, defenseSpeciale, vitesse);
    }

    @Override
    public void attaquer(Pokemon adversaire) {
        // 选择攻击方式，这里假设使用特殊攻击，威力50
        int puissance = 50;
        boolean special = true;

        int degats = calculerDommage(adversaire, puissance, special);
        adversaire.setHp(Math.max(adversaire.getHp() - degats, 0));

        System.out.println(getNom() + " 使用水系攻击！");
        // 类型效果提示
        if (getType().equals("Eau") && adversaire.getType().equals("Feu"))
            System.out.println("超级有效！");
        else if (getType().equals("Eau") && adversaire.getType().equals("Plante"))
            System.out.println("效果不佳...");
        System.out.println(adversaire.getNom() + " 失去 " + degats + " HP, 现在 HP: " + adversaire.getHp());
        System.out.println();
    }
}
