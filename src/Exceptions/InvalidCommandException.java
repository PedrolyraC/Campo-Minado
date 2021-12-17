package Exceptions;

public class InvalidCommandException extends RuntimeException {
    private static final long invalidPosition = 1L;

    public InvalidCommandException(){
        super();
    }

    @Override
    public String toString() {
        return "INVALID COMMAND...";
    }
}
