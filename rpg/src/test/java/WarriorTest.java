import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    @Test
    public void test(){
        // Dans ce test, je crée un guerrier et je simule son combat seul contre un mob immortel
        // Durant chaque tour, il inflige entre 1 et 7 points de dégâts.
        // Puis le mob l'attaque, le guerrier a 2 chances sur 7 de parer le coup.
        // Si le guerrier réussi a parer ou qu'il subit moins de dégats que son armure peut encaisser
        // alors il ne subit pas de dégât.
        // Sinon il subit des dégâts entre 0 et 4.
        // Quand le guerrier n'aura plus de vie, on arrête le commbat.
        Warrior warrior = new Warrior();
        while(warrior.lifePoints > 0){
            warrior.attack();
            System.out.println("Vous avez infligez " + warrior.weaponDamage + " points de dégât");
            warrior.defend();
            if(warrior.lifePoints > 0){
                System.out.println("Il vous reste " + warrior.lifePoints + " points de vie");
            } else{
                System.out.println("Vous n'avez plus de vie...\nVous êtes hors de combat");
            }
        }
    }
}