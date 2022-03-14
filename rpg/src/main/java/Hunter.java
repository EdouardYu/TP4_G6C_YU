import java.util.Random;

public class Hunter extends Hero {
    protected int arrows;

    public Hunter(){
        this.lifePoints = 15;
        this.armor = 3;
        this.arrows = 30;
        // Le héro chasseur a par défaut 15 points de vie, 3 point d'armure et 30 flèches
    }

    public void attack(){
        // Quand le chasseur attaque il inflige entre 0 à 6 points de dégâts aux ennemis
        // Et il perd une flèche
        Random random = new Random();
        this.weaponDamage = random.nextInt(7);
        this.arrows -= 1;
    }

    public void defend(){
        // Ici comme les codes dans la classe Game n'est pas encore fini,
        // je vais faire en sorte que le héro peut attaquer et se défendre durant chaque tour
        // (comme dans un JdR) pour faire plus facilement mes tests.
        // Je simmule les dégâts subient chaque tour
        // Le héro a 2 chances sur 7 de parer le coup
        // Si le héro réussi a parer ou qu'il subit moins de dégats que son armure peut encaisser
        // alors il ne subit pas de dégât.
        // Sinon il subit les dégâts moins l'armure
        Random random = new Random();
        int degat = random.nextInt(7);
        int defence = random.nextInt(7);
        if(defence < 5 && degat > this.armor){
            this.lifePoints += this.armor - degat;
        }
    }

    public void useConsumable(Consumable consumable) {
    }
    // Méthode pas encore implémentée...
}