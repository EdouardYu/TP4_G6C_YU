import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HunterTest{
    @Test
    public void test(){
        // Dans ce test, je crée un chasseur et je simule son combat seul contre un mob immortel
        // Durant chaque tour, il inflige entre 0 et 6 points de dégâts et perd une flèche.
        // Et quand il n'aura plus de flèche, il ne pourra plus attaquer.
        // Puis le mob l'attaque, le chasseur a 2 chances sur 7 de parer le coup.
        // Si le chasseur réussi a parer ou qu'il subit moins de dégats que son armure peut encaisser
        // alors il ne subit pas de dégât.
        // Sinon il subit des dégâts entre 0 et 4.
        // Quand le chasseur n'aura plus de vie, on arrête le commbat.
        Hunter hunter = new Hunter();
        while(hunter.lifePoints > 0){
            if (hunter.arrows > 0) {
                hunter.attack();
                System.out.println("Vous avez infligez " + hunter.weaponDamage + " points de dégât");
                System.out.println("Il vous reste " + hunter.arrows + " flèches");
            } else{
                System.out.println("Oh non ! Vous n'avez plus de flèches pour attaquer");
            }
            hunter.defend();
            if(hunter.lifePoints > 0){
                System.out.println("Il vous reste " + hunter.lifePoints + " points de vie");
            } else{
                System.out.println("Vous n'avez plus de vie...\nVous êtes hors de combat");
            }
        }
    }
}