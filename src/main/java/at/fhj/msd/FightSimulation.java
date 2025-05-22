package at.fhj.msd;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class FightSimulation {

    private List<Fighter> fighters = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void createFighters() {
        System.out.println("Hi. It's game \"Battle Area\". ");
        System.out.println("+---------+-------+------------");
        System.out.print("Choose how much player do you need (1,2,3): ");
        String NumberOfPlayer = scanner.nextLine();
        while (NumberOfPlayer) {
            case "1":

                break;
            case "2":

                break;

            case "3":

                break;
            default:
                throw new AssertionError();
        }

    }
}
