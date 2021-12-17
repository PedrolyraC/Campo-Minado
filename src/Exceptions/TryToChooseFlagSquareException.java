package Exceptions;

public class TryToChooseFlagSquareException extends RuntimeException{
    private static final long invalidPosition = 1L;

    public TryToChooseFlagSquareException(){
        super();
    }

    @Override
    public String toString() {
        return "INVALID COORDINATE. A FLAG HAS BEEN SET HERE";
    }
}
