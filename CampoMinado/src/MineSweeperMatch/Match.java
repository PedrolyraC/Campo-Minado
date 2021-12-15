package MineSweeperMatch;

import Enums.SquareSymbol;
import Exceptions.EmptySquareChoosenedException;
import Exceptions.OutOfTheBoardException;

import java.util.Scanner;

public class Match implements Comparable {
    private GameBoard board;
    private int playsMade;
    private long score;
    private String playerName;
    private int difficulty;
    private long time;
    private boolean gameOver;

    public Match(String playerName, int difficulty) {
        this.playerName = playerName;
        this.board = new GameBoard(difficulty);
        this.playsMade = 0;
        this.score = 0;
        this.time = 0;
        this.gameOver = false;
    }

    public GameBoard getBoard() {
        return board;
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    public int getPlaysMade() {
        return playsMade++;
    }

    public void setPlaysMade(int playsMade) {
        this.playsMade = playsMade;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public long matchScore(){
        score = this.score + 10;

        return score;
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

    public void startMatch(){
        Scanner sc = new Scanner(System.in);
        long startTime = System.nanoTime();
        Coordinates coords;
        boolean flag;

        while (!this.isGameOver() && !this.winner()) {
            this.gameStatus();
            System.out.println();
            coords = this.choosenSquare(sc);

            System.out.println("FLAG(Y/N): ");

            String s = sc.nextLine().trim();

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
                    this.score++;
                }
                else if (s.charAt(0) == 'y'){
                    this.board.setChoosened(coords, true);
                    this.score++;
                }
            }
            this.playsMade++;
            System.out.println("PRESS ANY KEY TO CONTINUE ");
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
        try {
            System.out.println("X COORDINATE: ");
            int line = sc.nextInt()-1;
            sc.nextLine();
            System.out.println("Y COORDINATE: ");
            int column = sc.nextInt()-1;
            sc.nextLine();
            Coordinates coord = new Coordinates(line, column);
            this.checkCoordinate(coord);
            return coord;
        }catch (OutOfTheBoardException e){
            System.out.println("\nINVALID COORDINATE\n");
            System.out.println("TRY AGAIN\n");
            System.out.println("X COORDINATE: ");
            int line = sc.nextInt()-1;
            sc.nextLine();
            System.out.println("Y COORDINATE: ");
            int column = sc.nextInt()-1;
            sc.nextLine();
            Coordinates coord = new Coordinates(line, column);
            this.checkCoordinate(coord);
            return coord;
        }
    }

    public static void clearScreen(){
        for(int i = 0; i < 1000; i++){
            System.out.println(" ");
        }
    }

    public void gameStatus(){

        System.out.print(this.board);
        System.out.println();
        System.out.println("PLAYER " + this.playerName.toUpperCase() +"\nROUND "
                + this.getPlaysMade() + "\nSCORE " + this.getScore() + "\nTIME " );
    }

    public void quitMatch(){
        //pegue pontuação, tempo e nome
        clearScreen();
        MenuInteractions.menu();
    }

    public void savedGame(){

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
