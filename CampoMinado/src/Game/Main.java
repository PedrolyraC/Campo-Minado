package Game;

import MineSweeperMatch.Match;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 3) {
            MenuInteractions.menu();
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    Match.clearScreen();
                    MenuInteractions.runMatch();
                    break;
                case 2:
                    Match.clearScreen();
                    MenuInteractions.showRanking();
                    break;
                case 3:
                    Match.clearScreen();
                    MenuInteractions.quitGame();
                    break;
            }
            Match.clearScreen();
        }
    }
}
