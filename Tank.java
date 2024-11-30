import java.util.Random;

public class Tank {
    float health;
    float defense;
    float dmgmodifier;
    int armorUpMin;
    int armorUpMax;
    int attackUpMin;
    int attackUpMax;
    String name;
    int id;
    Random rand = new Random();

    public Tank(float health, float defense, float dmgmodifier, int armorUpMin, int armorUpMax, int attackUpMin,
            int attackUpMax, String name, int id) {
        this.health = health;
        this.defense = defense;
        this.dmgmodifier = dmgmodifier;
        this.armorUpMin = armorUpMin;
        this.armorUpMax = armorUpMax;
        this.attackUpMin = attackUpMin;
        this.attackUpMax = attackUpMax;
        this.name = name;
        this.id = id;
    }

    public void Shoot(Tank target) {
        Random shootrand = new Random();
        if (target.health >= 0.1) {
            float damage = shootrand.nextInt(10) + 1;
            float raw_dmg = damage + this.dmgmodifier;
            damage = (damage + dmgmodifier) * (1 - (target.defense / 100));
            target.health -= damage;
            System.out.println("Tank " + id + " shot Tank " + target.id + " for " + damage + " damage!");
            System.out.println("Tank " + target.id + " now has " + target.health + " health!");
            System.out.println("Raw Damage: " + raw_dmg + "\r\nDamage Modifier: -" + target.defense + " percent");
            if (target.health <= 0.0) {
                System.out.println("Tank " + target.id + " has died!");
            }
        } else {
            System.out.println("This tank has died!");
        }
    }

    public void ArmorUp() {
        int max = this.armorUpMax, min = this.armorUpMin;
        Random armorrand = new Random();
        int armorup = armorrand.nextInt(max - min + 1) + min;
        System.out.println("Old Modifier: " + this.defense);
        this.defense += armorup;
        System.out.println("New Modifier: " + this.defense);
    }

    public void AttackUp() {
        int max = this.attackUpMax, min = this.attackUpMin;
        int dmgUp = rand.nextInt(max - min + 1) + min;
        System.out.println("Old Modifier: " + this.dmgmodifier);
        this.dmgmodifier += dmgUp;
        System.out.println("New Modifier: " + this.dmgmodifier);
    }

    // returns amount of attributes a tank has - right now, 4.
    public int getAttributes() {
        return 4;
    }

    public void battleInfo() {
        System.out.println("Tank Type: " + this.name + "\nTank Health: " + this.health + "\nTank Defense: "
                + this.defense + "\nTank Damage Boost: " + this.dmgmodifier + "\nTank Minimum ArmorUp: "
                + this.armorUpMin
                + "\nTank Maximum ArmorUp: " + this.armorUpMax + "\nTank Minimum AttackUp: " + this.attackUpMin
                + "\nTank Maximum AttackUp: " + this.attackUpMax + "\nTank id: " + this.id);
    }

    public static void main(String[] args) {

    }
}
