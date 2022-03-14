import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HealerTest{ 
    @Test
    public void test(){
        // Dans ce test, je crée un prêtre et je simule son combat seul contre un mob immortel
        // Durant chaque tour, quand les points de vie du prêtre est en dessous de la moitié de sa vie maximale,
        // il se soigne de 1 à 7 points de vie (dans la limite de ses points de vie max) et perd du mana.
        // Et quand il n'aura plus assez de mana, il ne pourra plus se soigner.
        // Puis le mob l'attaque, le prêtre a 2 chances sur 7 de parer le coup.
        // Si le prêtre réussi a parer ou qu'il subit moins de dégats que son armure peut encaisser
        // alors il ne subit pas de dégât.
        // Sinon il subit des dégâts entre 0 et 5.
        // Quand le prêtre n'aura plus de vie, on arrête le commbat.
        Healer healer = new Healer();
        int vieMax = healer.lifePoints;;
        while(healer.lifePoints > 0) {
            if(healer.lifePoints <= vieMax - vieMax / 2){
                if (healer.manaPoints >= healer.manaConsomme) {
                    healer.attack();
                    healer.lifePoints += healer.weaponDamage;
                    if (healer.lifePoints > vieMax) {
                        int soin = vieMax - healer.lifePoints + healer.weaponDamage;
                        healer.lifePoints = vieMax;
                        System.out.println("Vous vous êtes soigné de " + soin + " points de vie");
                    } else{
                        System.out.println("Vous vous êtes soigné de " + healer.weaponDamage + " points de vie");
                    }
                    System.out.println("Il vous reste " + healer.manaPoints + " points de mana");
                } else {
                    System.out.println("Oh non ! Vous n'avez plus de mana pour attaquer");
                }
            }
            healer.defend();
            if (healer.lifePoints > 0) {
                System.out.println("Il vous reste " + healer.lifePoints + " points de vie");
            } else {
                System.out.println("Vous n'avez plus de vie...\nVous êtes hors de combat");
            }
        }
    }
}