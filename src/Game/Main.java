package Game;

import MineSweeperMatch.Match;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int option;

        System.out.println("WELCOME TO MINESWEEPER!!\n");
        System.out.println("PRESS ANY BUTTON TO PLAY!!");

        option = sc.nextInt();

        MenuInteractions.menu();

        while (option != 1 || option != 2 || option != 3) {

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
