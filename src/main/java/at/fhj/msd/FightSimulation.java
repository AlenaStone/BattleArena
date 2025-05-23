package at.fhj.msd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FightSimulation {

    private List<Fighter> fighters = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Fighter fighter;

    public void runGame() {
        while (true) {
            System.out.println("Hi. It's game \"Battle Area\". ");
            System.out.println("+---------+-------+------------");
            System.out.println("Menu:");
            System.out.println("1.Play");
            System.out.println("2.How to play");
            System.out.println("3.Character Information");
            System.out.println("4.Exit");
            System.out.println("+---------+-------+------------");
            System.out.print("Pick a number:");
            String Menu = scanner.nextLine();
            System.out.println("+------------+--------+-------+------+");

            switch (Menu) {
                case "1":
                    createPlayersAndStartFight();
                    break;
                case "2":
                    showHowToPlay();
                    break;
                case "3":
                    showCharacterInfo();
                    break;
                case "4":
                    System.out.println("Exiting game. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
    }

    private void createPlayersAndStartFight() {
        System.out.print("Choose how much player do you need (2,3 or 4): ");

        String NumberOfPlayer = scanner.nextLine();
        if (!NumberOfPlayer.equals("4") && !NumberOfPlayer.equals("2") && !NumberOfPlayer.equals("3")) {
            System.out.println("Please enter a valid number of players (1, 2, or 3).");
            return;
        }
        fighters.clear();
        System.out.println("+---------+-------+------------");
        int number = Integer.parseInt(NumberOfPlayer);

        for (int i = 0; i < number; i++) {
            System.out.print("Choose the name of player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.println("+---------+-------+------------");
            fighter = null;

            while (fighter == null) {
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
                }
            }

            fighters.add(fighter);
            System.out.println("+---------+-------+------------");
            System.out.println(name + " chose " + fighter.getType());
            System.out.println("+---------+-------+------------");
            System.out.println("Characteristics of your " + fighter.getType() + ":");
            System.out.println("+--------+-------+------+");
            System.out.printf("| %-6s | %-5s | %-4s |\n", "Power", "Speed", "HP");
            System.out.println("+--------+-------+------+");
            System.out.printf("| %-6d | %-5d | %-4d |\n", fighter.getPower(), fighter.getSpeed(), fighter.getHp());
            System.out.println("+--------+-------+------+");

        }
        startFight();
    }

    private void showHowToPlay() {
        System.out.println("=== How to play ===");
        System.out.println("Welcome to Battle Area! Here's how you play the game:");
        System.out.println();
        System.out.println("1. Choose the number of players (2, 3, or 4).");
        System.out.println("   Each player will create their own fighter.");
        System.out.println();
        System.out.println("2. For each player:");
        System.out.println("   - Enter a name for your fighter.");
        System.out.println("   - Choose a fighter type:");
        System.out.println("     * Mage: balanced power and speed, with magical attacks.");
        System.out.println("     * Warrior: high HP, but slower speed and low power.");
        System.out.println("     * Archer: fast speed with moderate power.");
        System.out.println();
        System.out.println("3. After all fighters are created, the battle begins.");
        System.out.println("   Fighters attack each other in order of their speed (fastest first).");
        System.out.println("   Each attack reduces the opponent's HP.");
        System.out.println("   When a fighter's HP reaches zero, they are out of the game.");
        System.out.println();
        System.out.println("4. The battle continues until only one fighter remains alive.");
        System.out.println("   That fighter is declared the winner!");
        System.out.println();
        System.out.println("Good luck and have fun!");
        System.out.println("===================");
    }

    private void showCharacterInfo() {
        System.out.println("Character Information:");
        System.out.println("+------------+--------+-------+------+");
        System.out.printf("| %-10s | %-6s | %-5s | %-4s |\n", "Type", "Power", "Speed", "HP");
        System.out.println("+------------+--------+-------+------+");
        System.out.printf("| %-10s | %-6d | %-5d | %-4d |\n", "Mage", 10, 10, 100);
        System.out.printf("| %-10s | %-6d | %-5d | %-4d |\n", "Warrior", 5, 5, 200);
        System.out.printf("| %-10s | %-6d | %-5d | %-4d |\n", "Archer", 15, 15, 80);
        System.out.println("+------------+--------+-------+------+");
    }

    public void startFight() {
        Random random = new Random();

        int aliveCount = 0;
        for (Fighter f : fighters) {
            if (f.isAlive()) {
                aliveCount++;
            }
        }
        fighters.sort(Comparator.comparing(Fighter::getSpeed).reversed());

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

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        for (Fighter f : fighters) {
            if (f.isAlive()) {
                System.out.println("🏆 The winner is: " + f.getName());
                break;
            }
        }
    }
}
