public abstract class Pokemon {
    private int numeroNational;
    private String nom;
    private String type;
    private int niveau;
    private int hp;
    private int attaque;
    private int defense;
    private int attaqueSpeciale;
    private int defenseSpeciale;
    private int vitesse;

    // 构造函数
    public Pokemon(int numeroNational, String nom, String type, int niveau,
                   int hp, int attaque, int defense,
                   int attaqueSpeciale, int defenseSpeciale, int vitesse) {
        this.numeroNational = numeroNational;
        this.nom = nom;
        this.type = type;
        this.niveau = niveau;
        this.hp = hp;
        this.attaque = attaque;
        this.defense = defense;
        this.attaqueSpeciale = attaqueSpeciale;
        this.defenseSpeciale = defenseSpeciale;
        this.vitesse = vitesse;
    }

    // Getter / Setter
    //NumeroNational
    public int getNumeroNational() {
        return numeroNational;
    }
    public void setNumeroNational(int numeroNational) {
        this.numeroNational = numeroNational;
    }

    //Nom
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    //Type
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    //Niveau
    public int getNiveau() {
        return niveau;
    }
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    //Hp
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    //Attaque
    public int getAttaque() {
        return attaque;
    }
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    //Defense
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    //AttaqueSpecial
    public int getAttaqueSpeciale() {
        return attaqueSpeciale;
    }
    public void setAttaqueSpeciale(int attaqueSpeciale) {
        this.attaqueSpeciale = attaqueSpeciale;
    }

    //DefenseSpecial
    public int getDefenseSpeciale() {
        return defenseSpeciale;
    }
    public void setDefenseSpeciale(int defenseSpeciale) {
        this.defenseSpeciale = defenseSpeciale;
    }

    //Vitesse
    public int getVitesse() {
        return vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    // toString方法
    @Override
    public String toString() {
        return "Pokemon{" +
                "numeroNational=" + numeroNational +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", niveau=" + niveau +
                ", hp=" + hp +
                ", attaque=" + attaque +
                ", defense=" + defense +
                ", attaqueSpeciale=" + attaqueSpeciale +
                ", defenseSpeciale=" + defenseSpeciale +
                ", vitesse=" + vitesse +
                '}';
    }

    // 抽象方法：攻击
    public abstract void attaquer(Pokemon adversaire);

    // 计算伤害方法-有疑问
    public int calculerDommage(Pokemon adversaire, int puissance, boolean special) {
        int atk = special ? this.attaqueSpeciale : this.attaque;
        int def = special ? adversaire.getDefenseSpeciale() : adversaire.getDefense();

        double base = ((2.0 * this.niveau / 5 + 2) * puissance * ((double) atk / def) / 50) + 2;

        // 简单类型克制关系
        double multiplicateurType = 1.0;

        if (this.type.equals("Eau") && adversaire.getType().equals("Feu")) multiplicateurType = 2.0;
        if (this.type.equals("Eau") && adversaire.getType().equals("Plante")) multiplicateurType = 0.5;

        if (this.type.equals("Feu") && adversaire.getType().equals("Plante")) multiplicateurType = 2.0;
        if (this.type.equals("Feu") && adversaire.getType().equals("Eau")) multiplicateurType = 0.5;

        if (this.type.equals("Plante") && adversaire.getType().equals("Eau")) multiplicateurType = 2.0;
        if (this.type.equals("Plante") && adversaire.getType().equals("Feu")) multiplicateurType = 0.5;

        return (int) (base * multiplicateurType);
    }
}
