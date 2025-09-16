//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Combat {
    public static void main(String[] args) {

        // 1️⃣ 实例化两个宝可梦
        Pokemon squirtle = new EauPokemon(4, "Squirtle小龟龟", 40, 100, 80, 150, 102, 135, 43);
        Pokemon charmander = new FeuPokemon(7, "Charmander小龙龙", 100, 348, 98, 135, 110, 120 , 65);

        // 2️⃣ 显示宝可梦信息
        System.out.println("--- Début du Combat ---");
        System.out.println(squirtle);
        System.out.println(charmander);
        System.out.println();

        // 3️⃣ 回合制战斗
        Pokemon premier, second;

        if (squirtle.getVitesse() >= charmander.getVitesse()) {
            premier = squirtle;
            second = charmander;
        } else {
            premier = charmander;
            second = squirtle;
        }


        int tour = 1;
        while (squirtle.getHp() > 0 && charmander.getHp() > 0) {
            System.out.println("--- Tour " + tour + " ---");

            attaquerAvecEffet(premier, second);
            if (second.getHp() <= 0) {
                System.out.println(second.getNom() + " est KO !");
                break;
            }

            attaquerAvecEffet(second, premier);
            if (premier.getHp() <= 0) {
                System.out.println(premier.getNom() + " est KO !");
                break;
            }

            tour++;
            System.out.println();
        }

            System.out.println("--- Fin du Combat ---");
        }


    // 攻击方法，增加类型效果提示
    private static void attaquerAvecEffet(Pokemon attaquant, Pokemon defenseur) {
        System.out.println(attaquant.getNom() + " utilise une attaque !");

        int puissance = 50;
        boolean special = false;

        // 计算伤害
        int degats = attaquant.calculerDommage(defenseur, puissance, special);

        // 提示类型效果
        double multiplicateur = (double) degats / attaquant.calculerDommage(defenseur, puissance, special); // 这里先用1.0占位
        if (attaquant.getType().equals("Eau") && defenseur.getType().equals("Feu") ||
                attaquant.getType().equals("Feu") && defenseur.getType().equals("Plante") ||
                attaquant.getType().equals("Plante") && defenseur.getType().equals("Eau")) {
            System.out.println("C'est super efficace !");
        } else if (attaquant.getType().equals("Eau") && defenseur.getType().equals("Plante") ||
                attaquant.getType().equals("Feu") && defenseur.getType().equals("Eau") ||
                attaquant.getType().equals("Plante") && defenseur.getType().equals("Feu")) {
            System.out.println("Ce n'est pas très efficace...");
        }

        // 扣除HP
        defenseur.setHp(Math.max(defenseur.getHp() - degats, 0));
        System.out.println(defenseur.getNom() + " perd " + degats + " HP");
        System.out.println(defenseur.getNom() + " (HP: " + defenseur.getHp() + ")");
        System.out.println();

    }
}