import java.util.Random;

public class Warrior extends Hero {
    public Warrior(){
        // Le héro guerrier a par défaut 25 points de vie, 5 point d'armure
        this.lifePoints = 25;
        this.armor = 5;
    }

    public void attack(){
        // Quand le guerrier attaque il inflige entre 1 à 7 points de dégâts aux ennemis
        Random random = new Random();
        this.weaponDamage = random.nextInt(7) + 1 ;
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
