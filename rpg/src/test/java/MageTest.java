import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    @Test
    public void test(){
        // Dans ce test, je crée un mage et je simule son combat seul contre un mob immortel
        // Durant chaque tour, il inflige entre 3 et 9 points de dégâts et perd du mana.
        // Et quand il n'aura plus assez de mana, il ne pourra plus attaquer.
        // Puis le mob l'attaque, le mage a 2 chances sur 7 de parer le coup.
        // Si le mage réussi a parer ou qu'il subit moins de dégats que son armure peut encaisser
        // alors il ne subit pas de dégât.
        // Sinon il subit des dégâts entre 0 et 4.
        // Quand le mage n'aura plus de vie, on arrête le commbat.
        Mage mage = new Mage();
        while(mage.lifePoints > 0){
            if (mage.manaPoints >= mage.manaConsomme) {
                mage.attack();
                System.out.println("Vous avez infligez " + mage.weaponDamage + " points de dégât");
                System.out.println("Il vous reste " + mage.manaPoints + " points de mana");
            } else{
                System.out.println("Oh non ! Vous n'avez plus de mana pour attaquer");
            }
            mage.defend();
            if(mage.lifePoints > 0){
                System.out.println("Il vous reste " + mage.lifePoints + " points de vie");
            } else{
                System.out.println("Vous n'avez plus de vie...\nVous êtes hors de combat");
            }
        }
    }
}