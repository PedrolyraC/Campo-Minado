package Game;

import MineSweeperMatch.Match;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends MenuInteractions{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        ArrayList<Match> allMatches = new ArrayList<>();

        while (option != 3) {
            MenuInteractions.menu();
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    int gameOption = -1;

                    Match.clearScreen();

                    System.out.println("1)\tTRADITIONAL MODE\n" +
                                "2)\tRANDOM MODE");
                    gameOption = sc.nextInt();

                    switch (gameOption) {
                        case 1:
                            Match.clearScreen();
                            allMatches.add(MenuInteractions.traditional());
                            break;
                        case 2:
                            Match.clearScreen();
                            allMatches.add(MenuInteractions.randomMode());
                            break;
                        }
                    break;
                case 2:
                    Match.clearScreen();
                    showRanking(allMatches);
                    break;
                case 3:
                    Match.clearScreen();
                    quitGame(allMatches);
                    break;
            }
        }
    }
}
