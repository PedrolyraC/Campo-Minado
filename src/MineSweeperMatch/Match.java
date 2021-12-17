package MineSweeperMatch;

import Enums.SquareSymbol;
import Exceptions.EmptySquareChoosenedException;
import Exceptions.OutOfTheBoardException;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Match implements Comparable {
    private GameBoard board;
    private int playsMade;
    private long score;
    private String playerName;
    private long time;
    private long startTime;
    private boolean gameOver;

    public Match(String playerName, int difficulty) {
        this.playerName = playerName;
        this.board = new GameBoard(difficulty);
        this.playsMade = 0;
        this.score = 0;
        this.time = 0;
        this.gameOver = false;
        this.startTime = 0;
    }

    public int getPlaysMade() {
        return playsMade++;
    }

    public long getScore() {
        return score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public long getTime() {
        return time;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public long timer(){
        long timeCounter = System.nanoTime();

        return (timeCounter - this.startTime)/(1000000000);
    }

    public boolean winner(){
        Squares squareTest;
        int bombCounter = 0;
        int flagCounter = 0;

        for(int i = 0; i < this.board.getRows(); i++){
            for (int j = 0; j < this.board.getColumns(); j++){
                squareTest = this.board.getSquare(new Coordinates(i,j));
                if((squareTest.getSquare() == SquareSymbol.WHITESPACE
                        || squareTest.getSquare() == SquareSymbol.FLAG))
                {
                    flagCounter++;
                }
                if(squareTest.isBomb()){
                    bombCounter++;
                }
            }
        }
        return flagCounter == bombCounter;
    }

    public void startMatch() {
        Scanner sc = new Scanner(System.in);
        this.startTime = System.nanoTime();
        Coordinates coords;
        boolean okInput = false;

        while (!this.isGameOver() && !this.winner()) {
            this.gameStatus();
            System.out.println();
            coords = this.choosenSquare(sc);

            System.out.println("FLAG(Y/N): ");

            okInput = false;
            String s = null;

            while (!okInput){
                try {
                    s = sc.nextLine().trim().toLowerCase();
                    okInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("\nINPUT MISMATCH\n");
                    System.out.println("TRY AGAIN\n");
                    System.out.println("FLAG(Y/N)?");
                    sc = new Scanner(System.in);
                }
            }
            if (!this.board.getChoosened(coords)){
                if (s.charAt(0) == 'n') {
                    this.board.setChoosened(coords, false);
                    if (this.board.isBomb(coords)) {
                        this.gameOver = true;
                        System.out.println("GAME OVER");
                    } else {
                        this.board.openSquares(coords);
                        this.score++;
                    }
                } else if (s.charAt(0) == 'y') {
                    if (this.board.getSquare(coords).isFlag()) {
                        Match.clearScreen();
                        System.out.println("FLAG ALREADY PLACED\nWANT TO REMOVE THE ACTUAL FLAG(Y/N)?");
                        String s1 = sc.nextLine().trim().toLowerCase();

                        if (s.charAt(0) == 'y') {
                            this.board.setChoosened(coords, true);
                        }
                    } else {
                        this.board.setChoosened(coords, true);
                    }
                }
            }
            this.playsMade++;
            System.out.println("PRESS ANY KEY TO CONTINUE ");
            save("match.txt");
            sc.nextLine();
        }

        long matchTime = System.nanoTime();
        this.time = matchTime - startTime;
        if (this.winner()){
            System.out.println("YOU WIN!!!");
        }
        this.board.printAll();
        System.out.println("PRESS ANY KEY TO CONTINUE ");
        sc.nextLine();
    }

    public void checkCoordinate(Coordinates coord) throws OutOfTheBoardException, EmptySquareChoosenedException {
        if (!(coord.getX() >= 0 && coord.getX() < this.board.getRows()
                && coord.getY() >= 0 && coord.getY() < this.board.getColumns()))
        {
            throw new OutOfTheBoardException();
        }
        if (this.board.isEmpty(coord)){
            throw new EmptySquareChoosenedException();
        }
    }

    public Coordinates choosenSquare(Scanner sc){
        boolean okInput = false;
        Coordinates coords = null;

        while (!okInput) {
            try {
                System.out.println("X COORDINATE: ");
                int line = sc.nextInt() - 1;
                sc.nextLine();
                System.out.println("Y COORDINATE: ");
                int column = sc.nextInt() - 1;
                sc.nextLine();
                coords = new Coordinates(column, line);
                this.checkCoordinate(coords);
                okInput = true;
            } catch (OutOfTheBoardException e) {
                System.out.println("\nINVALID COORDINATE\n");
                System.out.println("TRY AGAIN\n");
                System.out.println("X COORDINATE: ");
                sc = new Scanner(System.in);
            } catch (InputMismatchException e) {
                System.out.println("\nINPUT MISSMATCH\n");
                System.out.println("TRY AGAIN\n");
                System.out.println("X COORDINATE: ");
                sc = new Scanner(System.in);
            }
        }
        return coords;
    }

    public static void clearScreen(){
        for(int i = 0; i < 100; i++){
            System.out.println(" ");
        }
    }

    public void gameStatus(){

        System.out.print(this.board);
        System.out.println();
        System.out.println("PLAYER " + this.playerName.toUpperCase() +"\nROUND "
                + this.getPlaysMade() + "\nSCORE " + this.getScore()*100 + "\nTIME " + timer() + "s" );
    }

    public void save(String filename){
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
            bw.write(this.getPlayerName());
            bw.newLine();
            bw.write(String.valueOf(this.getScore()));
            bw.newLine();
            bw.close();
        }
        catch (IOException except) {
            System.out.println("ERRROR TRYING OPENING FILE " + filename);
        }
    }

    public static ArrayList<Match> load(String filename){
        ArrayList<Match> savedMatches = new ArrayList<>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        }
        catch (IOException except) {
            System.out.println("ERRROR TRYING OPENING FILE " + filename);
        }
        return savedMatches;
    }

    @Override
    public int compareTo(Object o) {
        return (int) (((Match)o).getTime() - this.getTime()); // do menor para o maior
    }
}
