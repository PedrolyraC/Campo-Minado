package Game;

import MineSweeperMatch.GameBoard;
import MineSweeperMatch.Match;

import java.util.Scanner;

public class MenuInteractions {

    public static void menu() {
        System.out.print("MINESWEEPER\n\n" +
                  "1)\tPLAY\n"
                + "2)\tRANKING\n"
                + "3)\tEXIT\n");

    }

    public static Match runMatch(){
        System.out.println("INSERT PLAYER NAME: ");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine().strip();
        int option;
        do {
            System.out.println("DIFICULTY: \n1)EASY\n2)MEDIUM\n3)HARD\n");
            option = sc.nextInt();
            sc.nextLine();
            if (option<1 && option>3){
                System.out.println("\tINVALID OPTION\n");
            }
        } while (option<1 && option>3);

        int dificulty = 0;
        switch (option){
            case 1:
                dificulty = 1;
                break;
            case 2:
                dificulty = 2;
                break;
            case 3:
                dificulty = 3;
                break;
        }

        Match match = new Match(playerName, dificulty);
        match.startMatch();
        return match;

    }

    public static void showRanking(){

    }

    public static void quitGame(){
        System.out.println("Thank You For Playing,"+ runMatch().getPlayerName() +"!!!");

    }
}
