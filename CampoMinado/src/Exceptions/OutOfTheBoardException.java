package Exceptions;

public class OutOfTheBoardException extends RuntimeException {
    private static final long invalidPosition = 1L;

    public OutOfTheBoardException(){
        super();
    }

    @Override
    public String toString() {
        return "INVALID COORDINATES...";
    }
}
