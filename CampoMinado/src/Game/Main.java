package Game;

import java.awt.*;
import java.util.ArrayList;
import MineSweeperMatch.Match;

public class Main {
    public static void main(String[] args){
        System.out.println();
        ArrayList<Match> matches = new ArrayList<Match>();
        int option = 5;
        while(option != 3){
            option = MenuInteractions.menu();
            switch (option){
                case 1: // Jogar
                    matches.add(MenuInteractions.runMatch());
                    break;
                case 2: // Ranking
                    MenuInteractions.showRanking(matches);
                    break;
                case 3: // Sair
                    break;
            }
        }
        System.out.println("Bye!");

    }
}
