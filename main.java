public class main {
  public static void main(String[] args) {
    Tank tank1 = new Tank(50, 10, 0, 1);
    Tank tank2 = new Tank(50, 10, 0, 2);
    Tank tank3 = new Tank(50, 10, 0, 3);

    tank2.ArmorUp();
    tank1.Shoot(tank2);
  }
}