package MineSweeperMatch.Dinamics;

import java.util.Scanner;
import java.lang.System;

public class Play {
    private int time;
    private Coordinates coord;

    public Play(){
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
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }
}
