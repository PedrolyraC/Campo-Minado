package Game;
import MineSweeperMatch.Match;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuInteractions {

    public static int menu() {
        System.out.print("CAMPO MINADO\n\n"
                + "Opção\tDescrição\n"
                + "1)     \tJogar\n"
                + "2)     \tRanking\n"
                + "3)     \tSair\n"
                + "-> ");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        sc.nextLine();

        return option;
    }

    public static Match runMatch(){
        System.out.println("Player name: ");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine().strip();
        int option;
        do {
            System.out.println("Level: \n1)Easy\n2)Medium\n3)Hard\n-> ");
            option = sc.nextInt();
            sc.nextLine();
            if (option<1 && option>3){
                System.out.println("\tOpção inválida!\n");
            }
        } while (option<1 && option>3);

        int level = 0;
        switch (option){
            case 1:
                level = EASY;
                break;
            case 2:
                level = MEDIUM;
                break;
            case 3:
                level = HARD;
                break;
        }

        Match match = new Match(playerName, level);
        match.startMatch();
        return match;
    }

    public static void showRanking(ArrayList<Match> matches){
        //matches.sort();
        System.out.println("RANKING\n\n");
        for (Match match : matches){
            System.out.println(match.getPlayerName() + "\t" + match.getTime() +"\t" +match.getScore());
        }
    }

    public void quitGame(){

    }
}
