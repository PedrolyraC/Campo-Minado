package Game;

import java.util.ArrayList;
import java.util.Scanner;
import MineSweeperMatch.*;
import MineSweeperMatch.Dinamics.*;

public class Main {
    public static void main(String[] args){
        ArrayList<Match> matches = new ArrayList<Match>();
        int option = 5;
        while(option != 3){
            option = menu();
            switch (option){
                case 1: // Jogar
                    matches.add(runMatch());
                    break;
                case 2: // Ranking
                    showRanking(matches);
                    break;
                case 3: // Sair
                    break;
            }
        }
        System.out.println("Bye!");
    }

    /* Imprime o menu e retorna a opção desejada do usuário. */
    public static int menu(){
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

    /* Executa uma partida e retorna sua referência. */
    public static Match runMatch(){
        return null;
    }

    public static void showRanking(ArrayList<Match> matches){
        //matches.sort();
        System.out.println("RANKING\n\n");
        for (Match match : matches){
            System.out.println(match.getPlayerName() + "\t" + match.getTime() +"\t" +match.getScore());
        }
    }
}
