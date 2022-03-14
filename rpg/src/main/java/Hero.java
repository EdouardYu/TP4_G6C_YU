import java.util.ArrayList;

abstract public class Hero {
    protected String name;
    protected int lifePoints;
    protected int armor;
    protected int weaponDamage;
    protected ArrayList<Potion> potions;
    protected ArrayList<Food> lembas;

    abstract public void attack();
    abstract public void defend();
    abstract public void useConsumable(Consumable consumable);

    public void givePotion(){
        Potion potion = new Potion();
        this.potions.add(potion);
    }

    public void giveFood(){
        Food food = new Food();
        this.lembas.add(food);
    }
}

// Mes héros possèdent tous un nom, des points de vie, des points d'armure, des points de dégât,
// un inventaire (une liste) de potions et un inventaire (une liste) de nourritures
// Ils peuvent également tous attaquer, défendre, ou consommer un consommable
// Et ils peuvent recevoir plus de potions ou de nourritures
