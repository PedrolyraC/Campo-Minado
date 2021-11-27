package MineSweeperMatch;

import java.lang.System;
import java.util.Scanner;
import Enums.*;

public class Match {
    private GameBoard board;
    private int playsMade;
    private long score;
    private String playerName;
    private Level level;
    private long time;
    private boolean gameOver;

    public Match(String playerName, Level level) {
        this.playerName = playerName;
        this.level = level;
        this.board = new GameBoard(this.level);
        this.playsMade = 0;
        this.score = 0;
        this.time = 0;
        this.gameOver = false;
    }

    public void startMatch(){
        long startTime = System.nanoTime();

        // Main match loop
        while (!this.isGameOver()) {
            System.out.println(this.board);
            break;
        }

        long endTime =  System.nanoTime();
        this.time = endTime - startTime;
    }

    public void play(){
        /*
        int x, y;
        Scanner sc = new Scanner(System.in);
        long startTime = System.nanoTime();
        System.out.println("Entre com a posição X: ");
        x = sc.nextInt();
        sc.nextLine();
        System.out.println("Entre com a posição Y: ");
        y = sc.nextInt();
        sc.nextLine();
        long endTime = System.nanoTime();
        this.time = (int)(endTime - startTime)/1000000;
        this.coord = new Coordinates(x, y);
        */
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
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

    public int matchScore(){
        return 0;
    }

    public boolean isGameOver(){
        return this.gameOver;
    }

    public Squares choosenSquare(){
        return null;
    }

    public boolean possibleMoves(){
    return false;
    }

    public int clearScreen(){
        return 0;
    }

    public void gameStatus(){

    }

    public void quitMatch(){

    }
}
