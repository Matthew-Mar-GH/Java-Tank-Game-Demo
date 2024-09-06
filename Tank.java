import java.util.Random;
public class Tank {
  int health;
  int defense;
  float dmgmodifier;
  int id;
  public Tank(int health, int defense, int dmgmodifier, int id) {
    this.health = health;
    this.defense = defense;
    this.dmgmodifier = dmgmodifier;
    this.id = id;
  }
  public void Shoot(Tank target) {
    Random shootrand = new Random();
    float damage = shootrand.nextInt(10);
    float raw_dmg = damage;
    damage = damage * (1 - (target.dmgmodifier/100));
    target.health -= damage;
    System.out.println("Tank " + id + " shot Tank " + target.id + " for " + damage + " damage!");
    System.out.println("Tank " + target.id + " now has " + target.health + " health!");
    System.out.println("Raw Damage: " + raw_dmg + "\r\nDamage Modifier: " + target.dmgmodifier);
  }
  public void ArmorUp() {
    int max = 25, min = 10;
    Random armorrand = new Random();
    int armorup = armorrand.nextInt(max - min + 1) + min;
    System.out.println("Old Modifier: " + this.dmgmodifier);
    this.dmgmodifier = this.dmgmodifier + armorup;
    System.out.println("New Modifier: " + this.dmgmodifier);
  }

  public static void main(String[] args) {

  }
}