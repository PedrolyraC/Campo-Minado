package Game;

import MineSweeperMatch.Match;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class MenuInteractions implements GameStyle {

    public static void menu() {
        System.out.print("MINESWEEPER\n\n" +
                  "1)\tPLAY\n"
                + "2)\tRANKING\n"
                + "3)\tEXIT\n");

    }

    public static Match traditional() throws IOException {
        System.out.println("INSERT PLAYER NAME: ");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine().strip();
        int option = -1;

        Match.clearScreen();
        System.out.println("DIFICULTY: \n1)EASY\n2)MEDIUM\n3)HARD\n");
        option = sc.nextInt();
        sc.nextLine();
        if (option<1 && option>3){
            System.out.println("\tINVALID OPTION\n");
        }

        int dificulty = -1;

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

        Match.clearScreen();
        Match match = new Match(playerName, dificulty);
        match.startMatch();
        return match;

    }

    public static Match randomMode () throws IOException {
        System.out.println("INSERT PLAYER NAME: ");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine().strip();
        int option = -1;

        Match.clearScreen();
        System.out.println("DIFICULTY: \n1)EASY\n2)MEDIUM\n3)HARD\n");
        option = sc.nextInt();
        sc.nextLine();
        if (option<1 && option>3){
            System.out.println("\tINVALID OPTION\n");
        }

        int dificulty = -1;

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

        Match.clearScreen();
        Match match = new Match(playerName, dificulty);
        match.startMatch();
        return match;

    }

    public static void showRanking(ArrayList<Match> matches) throws IOException {
        int place = 1;
        Collections.sort(matches);
        Scanner sc = new Scanner(System.in);
        String str;
        BufferedWriter bw = new BufferedWriter(new FileWriter("ranking.txt", true));

        for (Match match : matches) {
            if (!match.isGameOver()) {
                str = place + " - " + match.getPlayerName() + " - " + match.timer();
                bw.write(str);
                bw.newLine();
                bw.close();
            }
        }
        BufferedReader br = new BufferedReader(new FileReader("ranking.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        System.out.println("PRESS ANY KEY TO RETURN");
        sc.nextLine();
    }

    public static void quitGame(ArrayList<Match> matches) throws IOException {
        System.out.println("Thank You For Playing!!!");
        for (Match match : matches){
            System.out.println("\t"+ match.getPlayerName());
        }
    }
}
