import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import utils.InputParser;

public class Game {
    private ArrayList<Hero> heroes;
    private ArrayList<Enemy> enemies;
    private int playerTurn;
    private InputParser inputParser;

    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        // On demmande combien y'a t'il de héros qui participeront à l'aventure
        System.out.println("Choisissez le nombre de héros qui participeront à l'aventure !");
        // On crée une liste de héros avec autant de héros qui participent à l'aventure dans la liste
        // On demande à tous les héros de la liste leur nom et leur classe de personnage
        // (Guerrier, Chasseur, Mage ou Prêtre)
        int nombreDeHeros = scanner.nextInt();
        this.heroes = new ArrayList<Hero>();
        for(int i = 1; i <= nombreDeHeros; i++){
            String nomDuHero;
            int classe;
            Scanner scan = new Scanner(System.in);
            if(i == 1){
                System.out.println("Quelle est le nom du 1er héro ?");
                nomDuHero = scan.nextLine();
                do{
                    System.out.println("Quelle est sa classe ? \n1 : Guerrier\n2 : Chasseur\n3 : Mage\n4 : Soigneur");
                    classe = scan.nextInt();
                } while(classe < 1 || classe > 4);
            } else{
                System.out.println("Quelle est le nom du " + i + "e héro ?");
                nomDuHero = scan.nextLine();
                do{
                    System.out.println("Quelle est sa classe ? \n1 : Guerrier\n2 : Chasseur\n3 : Mage\n4 : Soigneur");
                    classe = scan.nextInt();
                } while(classe < 1 || classe > 4);
            }
            switch (classe){
                case 1 :
                    Warrior warrior = new Warrior();
                    warrior.name = nomDuHero;
                    this.heroes.add(warrior);
                    break;
                case 2 :
                    Hunter hunter = new Hunter();
                    hunter.name = nomDuHero;
                    this.heroes.add(hunter);
                    break;
                case 3 :
                    Mage mage = new Mage();
                    mage.name = nomDuHero;
                    this.heroes.add(mage);
                    break;
                case 4 :
                    Healer healer = new Healer();
                    healer.name = nomDuHero;
                    this.heroes.add(healer);
                    break;
            }
        }
        // Pour tous ces héros de la liste, on crée un inventaire (une liste) de potions et on leur donne 5 potions
        // et on crée un inventaire (une liste) de nourritures et on leur donne 10 nourritures
        for (Hero hero : this.heroes){
            hero.potions = new ArrayList<Potion>();
            for(int i = 0; i < 5; i++){
                hero.givePotion();
            }
            hero.lembas = new ArrayList<Food>();
            for(int i = 0; i < 10; i++){
                hero.giveFood();
            }
            System.out.println("Nom du héro : " + hero.name);
            System.out.println(hero.getClass());
            System.out.println("Points de vie : " + hero.lifePoints);
            System.out.println("Nombre de potions : " + hero.potions.size());
            System.out.println("Quantité de nourritures : " + hero.lembas.size());
        }
        // On génère un combat (code pas encore terminé...)
        // Je voudrai faire en sorte de continuer de générer des combats
        // tant que tous les héros ne sont pas morts et qu'ils continuent de gagner leurs combat
        // Si tous les héros sont morts (retiré de la liste de héro), on affiche un GAME OVER
        generateCombat(heroes.size());
    }

    public void generateCombat(int nombreDeHerosVivant){
        // Pour chaque nouveau combat, on crée une liste d'ennemies dont une fois sur cinq c'est un combat de boss.
        // Le combat de boss comporte 1 ogre et 2 gobelins
        // et le combat classique comporte autant de gobelins que de héros encore en vie.
        // (Le code pas encore terminé...)
        // Je voudrai faire en sorte de générer aléatoirement l'ordre des tours d'attaque
        // entres tous les héros et tous les ennemis
        // Chaque héros pourront choisir entre attaquer ou défendre ou consommer un consommable
        // A chaque héro ou ennemi mort, je les enlève de leur liste
        // A la fin du combat si tous les ennemis sont morts, les héros encore en vie reçoivent autant de points
        // que d'ennemies (le boss compte 5 points) à répartir entre la vie, les dégâts, l'armure,
        // le nombre de potions ou de nourritures, l'efficacité des potions ou des nourritures,
        // le nombre de flèches (pour les chasseurs),
        // la quantité ou le coût de mana pour les sorts (pour les mages et les prêtres).
        this.enemies = new ArrayList<Enemy>();
        Random random = new Random();
        int combatAleatoire = random.nextInt(5);
        if(combatAleatoire == 0) {
            System.out.println("Oh ! Vous êtes tombé sur un boss avec deux sbires !\nPréparez-vous à combattre");
            Enemy boss = new Boss();
            Enemy enemy1 = new BasicEnemy();
            Enemy enemy2 = new BasicEnemy();
            this.enemies.add(boss);
            this.enemies.add(enemy1);
            this.enemies.add(enemy2);
        } else{
            System.out.println(nombreDeHerosVivant + " monstres vous attaquent !\nPréparez-vous à combattre");
            for (int i = 0; i < nombreDeHerosVivant; i++) {
                Enemy enemy = new BasicEnemy();
                this.enemies.add(enemy);
            }
        }
        for (Enemy enemy : this.enemies){
            System.out.println("Un " + enemy.name + " apparaît");
        }
    }
}
