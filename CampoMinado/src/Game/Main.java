package Game;

import MineSweeperMatch.Match;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends MenuInteractions{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int option = -1;
        ArrayList<Match> allMatches = new ArrayList<>();

        while (option != 3) {
            MenuInteractions.menu();
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    Match.clearScreen();
                    MenuInteractions.traditional();
                    break;
                case 2:
                    Match.clearScreen();
                    MenuInteractions.showRanking(allMatches);
                    break;
                case 3:
                    Match.clearScreen();
                    MenuInteractions.quitGame(allMatches);
                    break;
            }
            Match.clearScreen();
        }
    }
}
