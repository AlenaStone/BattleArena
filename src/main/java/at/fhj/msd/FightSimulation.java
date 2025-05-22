package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FightSimulation {

    private List<Fighter> fighters = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Fighter fighter;

    public void createFighters() {
        System.out.println("Hi. It's game \"Battle Area\". ");
        System.out.println("+---------+-------+------------");
        System.out.print("Choose how much player do you need (1,2 or 3): ");
        
        String NumberOfPlayer = scanner.nextLine();
        if(!NumberOfPlayer.equals("1") && !NumberOfPlayer.equals("2") && !NumberOfPlayer.equals("3")) {
            System.out.println("Please enter a valid number of players (1, 2, or 3).");
            return;
        }
        System.out.println("+---------+-------+------------");
        int number = Integer.parseInt(NumberOfPlayer);
        for (int i = 0; i < number; i++) {
            System.out.print("Choose the name of player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.println("+---------+-------+------------");
            System.out.print("Choose the type of player (Archer, Mage, Warrior): ");
            String type = scanner.nextLine();

            if (type.equalsIgnoreCase("Archer")) {
                fighter = new Archer(name);
            } else if (type.equalsIgnoreCase("Mage")) {
                fighter = new Mage(name);

            } else if (type.equalsIgnoreCase("Warrior")) {
                fighter = new Warrior(name);
            } else {
                System.out.println("Unknown fighter type, please try again.");
                i--;
                continue;
            }
            fighters.add(fighter);
        }
    }
}
