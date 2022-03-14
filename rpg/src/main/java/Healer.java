import java.util.Random;

public class Healer extends SpellCaster {
    public Healer(){
        // Le héro prêtre a par défaut 10 points de vie, 1 point d'armure,
        // 20 points de mana et consomme 3 points de mana par sort
        this.lifePoints = 10;
        this.armor = 1;
        this.manaPoints = 20;
        this.manaConsomme = 3;
    }

    public void attack(){
        // Quand le prêtre attaque il soigne entre 1 à 7 points de vie ses alliés ou lui même
        // dans la limite des points de vie max du héro soigné
        // Et il consomme son mana
        Random random = new Random();
        this.weaponDamage = random.nextInt(7) + 1;
        this.manaPoints -= this.manaConsomme;
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
