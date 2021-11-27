package MineSweeperMatch;

import Exceptions.OutOfTheBoardException;
import Game.MenuInteractions;

import java.util.Scanner;

public class Match {
    private GameBoard board;
    private int playsMade;
    private long score;
    private String playerName;
    private int difficulty;
    private long time;
    private boolean gameOver;

    public Match(String playerName, int difficulty) {
        this.playerName = playerName;
        this.board = new GameBoard(difficulty); // ajeitar colocando new Board
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
        return playsMade;
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

    public void startMatch(){
        long startTime = System.nanoTime();

        while (!this.isGameOver()) {
            System.out.print(this.board);
        }

        long matchTime = System.nanoTime();
        this.time = matchTime - startTime;
    }

    public static void choosenSquare(Scanner sc){
        try {
            String str = sc.nextLine();
            char column = str.charAt(0);
            int line = Integer.parseInt(str.substring(1));
        }catch (RuntimeException e){
            throw new OutOfTheBoardException();
        }
    }

    /*public boolean possibleMoves(){
        if()
    } */

    public static void clearScreen(){
        for(int i = 0; i < 1000; i++){
            System.out.print(" ");
        }
    }

    public void gameStatus(){
        System.out.println("Round " + this.getPlaysMade()+ 1 + "\nScore " + this.getScore());
    }

    public void quitMatch(){
        //pegue pontuação, tempo e nome
        clearScreen();
        MenuInteractions.menu();
    }
}
