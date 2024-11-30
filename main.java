import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static String divider() {
        return "-------------------------\n";
    }

    public static void main(String[] args) {

        boolean isRun = true;
        Scanner console = new Scanner(System.in);

        System.out.print(divider()
                + "Welcome to the Java Tank Game Demo v0.8! Please select how many tanks you want!\n"
                + divider());
        int tankCount = console.nextInt();
        Tank dummyTank = new Tank(0, 0, 0, 0, 0, 0, 0, "idiot", 9999999);
        int attributes = dummyTank.getAttributes();
        List<List<Float>> tankTypesF = new ArrayList<>();

        tankTypesF.add(List.of(45f, 15f, 5f));
        tankTypesF.add(List.of(60f, 20f, 0f));
        tankTypesF.add(List.of(35f, 5f, 20f));
        tankTypesF.add(List.of((float) getRandomInt(40, 60), (float) getRandomInt(5, 12), (float) getRandomInt(0, 5)));

        List<List<Integer>> tankTypesI = new ArrayList<>();

        tankTypesI.add(List.of(5, 10, 7, 12));
        tankTypesI.add(List.of(7, 12, 3, 5));
        tankTypesI.add(List.of(5, 10, 10, 20));
        tankTypesI.add(List.of(getRandomInt(2, 5), getRandomInt(6, 9), getRandomInt(3, 7), getRandomInt(8, 12)));

        List<String> tankNames = new ArrayList<>();

        tankNames.add("Beserker");
        tankNames.add("Tanky");
        tankNames.add("Glass");
        tankNames.add("Random");

        List<Tank> tanks = new ArrayList<>();

        for (int i = 0; i < tankCount; i++) {
            System.out.print(divider());
            System.out
                    .println(
                            "Please select what types of tanks you want! /(Check the README for details on tank statistics/)\n1: Beserker\n2: Tanky\n3: Glass\n4: Random");
            System.out.print(divider());
            int tankChoice = console.nextInt();
            tanks.add(new Tank(tankTypesF.get(tankChoice - 1).get(0).floatValue(),
                    tankTypesF.get(tankChoice - 1).get(1).floatValue(),
                    tankTypesF.get(tankChoice - 1).get(2).floatValue(), tankTypesI.get(tankChoice - 1).get(0),
                    tankTypesI.get(tankChoice - 1).get(1), tankTypesI.get(tankChoice - 1).get(2),
                    tankTypesI.get(tankChoice - 1).get(3), tankNames.get(tankChoice - 1),
                    i + 1));
            System.out.print(divider());
        }

        do {
            System.out.print(
                    divider()
                            + "What action is taken? Enter the integer corresponding with the action!\nArmor: 1\nShoot: 2\nAttack Up: 3\nTank Info: 4\n"
                            + divider());
            int action = console.nextInt();

            if (action == 1) {
                System.out.print(divider());
                System.out.print("Which tank armors up? (Use Tank id): ");
                int actionTarget = console.nextInt();
                if (actionTarget >= 1 && actionTarget <= tanks.size()) {
                    tanks.get(actionTarget - 1).ArmorUp();
                } else {
                    System.out.print("Invalid tank ID!");
                }
                System.out.println(divider());
            } else if (action == 2) {
                System.out.print(divider());
                System.out.print("Which tank shoots? (Use Tank id): ");
                int shooterId = console.nextInt();
                if (shooterId >= 1 && shooterId <= tanks.size()) {
                    System.out.print("At? (Use Tank id): ");
                    int targetId = console.nextInt();
                    if ((targetId >= 1 && targetId <= tanks.size()) && targetId != shooterId) {
                        tanks.get(shooterId - 1).Shoot(tanks.get(targetId - 1));
                    } else {
                        System.out.println("Invalid target tank ID!/This tank cannot shoot itself!");
                    }
                } else {
                    System.out.print("Invalid shooter tank ID!");
                }
                System.out.println(divider());
            } else if (action == 3) {
                System.out.print(divider());
                System.out.print("Which tank boosts damage? (Use Tank id): ");
                int actionTarget = console.nextInt();
                if (actionTarget >= 1 && actionTarget <= tanks.size()) {
                    tanks.get(actionTarget - 1).AttackUp();
                } else {
                    System.out.print("Invalid tank ID!");
                }
            } else if (action == 4) {
                for (int i = 0; i < tankCount; i++) {
                    System.out.print(divider());
                    tanks.get(i).battleInfo();
                    System.out.print(divider());
                }
            }
        } while (isRun);

        console.close();
    }

    public static int getRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
