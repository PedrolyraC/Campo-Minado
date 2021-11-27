package Enums;

import java.util.Random;

public enum SquareSymbol {
    FLAG,BOMB,WHITESPACE,NUMBER,EMPTY;

    public static SquareSymbol randomSquareSymbolGenerator(){
        Random random = new Random();

        return values()[random.nextInt(values().length)];
    }
}
