package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FightSimulation {

    private List<Fighter> fighters = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Fighter fighter;

    public void createFighters() {
        System.out.println("Hi. It's game \"Battle Area\". ");
        System.out.println("+---------+-------+------------");
        System.out.print("Choose how much player do you need (2,3 or 4): ");

        String NumberOfPlayer = scanner.nextLine();
        if (!NumberOfPlayer.equals("4") && !NumberOfPlayer.equals("2") && !NumberOfPlayer.equals("3")) {
            System.out.println("Please enter a valid number of players (1, 2, or 3).");
            return;
        }
        System.out.println("+---------+-------+------------");
        int number = Integer.parseInt(NumberOfPlayer);
        for (int i = 0; i < number; i++) {
            System.out.print("Choose the name of player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.println("+---------+-------+------------");

            System.out.println("1.Mage");
            System.out.println("2.Warrior");
            System.out.println("3.Archer");
            System.out.print("Choose the type of player: ");
            String type = scanner.nextLine();

            if (type.equalsIgnoreCase("Archer") || type.equals("3")) {
                fighter = new Archer(name);

            } else if (type.equalsIgnoreCase("Mage") || type.equals("1")) {
                fighter = new Mage(name);

            } else if (type.equalsIgnoreCase("Warrior") || type.equals("2")) {
                fighter = new Warrior(name);

            } else {
                System.out.println("Unknown fighter type, please try again.");
                i--;
                continue;
            }
            fighters.add(fighter);
            System.out.println("+---------+-------+------------");
            System.out.println(name + " choose " + fighter.getType());
            System.out.println("+---------+-------+------------");
            System.out.println("Characteristics of your " + fighter.getType() + " :");
            System.out.println("Your power: " + fighter.getPower());
            System.out.println("Your speed: " + fighter.getSpeed());
            System.out.println("Your HP: " + fighter.getHp());
            System.out.println("+---------+-------+------------");

        }
    }

    public void startFight() {

        Random random = new Random();

        int aliveCount = 0;
        for (Fighter f : fighters) {
            if (f.isAlive()) {
                aliveCount++;
            }
        }
        while (aliveCount > 1) {
            aliveCount = 0;
            for (Fighter f : fighters) {

                if (f.isAlive()) {
                    aliveCount++;
                }
            }
            if (aliveCount <= 1) {
                break;
            }

            for (Fighter f : fighters) {
                if (f.isAlive()) {
                    int attackerIndex = fighters.indexOf(f);
                    int targetIndex = random.nextInt(fighters.size());
                    while (attackerIndex == targetIndex || fighters.get(targetIndex).getHp() == 0) {
                        targetIndex = random.nextInt(fighters.size());
                    }
                    Fighter target = fighters.get(targetIndex);
                    fighters.get(targetIndex).takeDamage(f.getPower());

                    System.out.println("-------------------------");
                    System.out.println(f.getName() + " attacks " + target.getName() + " for " + f.getPower() + " damage.");
                    System.out.println(target.getName() + " HP left: " + target.getHp());
                    System.out.println("-------------------------");
                }
            }
        }
    }
}
