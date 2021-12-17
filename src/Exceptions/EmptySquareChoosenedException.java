package Exceptions;

public class EmptySquareChoosenedException extends RuntimeException {
    private static final long invalidPosition = 1L;

    public EmptySquareChoosenedException(){
        super();
    }

    @Override
    public String toString() {
        return "THIS SQUARE HAS ALREADY BEENS CHOOSED AND IT'S EMPTY. PLEASE CHOOSE ANOTHER ONE: ";
    }
}
