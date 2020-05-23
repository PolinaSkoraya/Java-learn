package exceptions;

public class CasementException extends Exception {
    int number;

    public CasementException() {
    }

    public CasementException(String message) {
        super (message);
    }

    public CasementException(String message, int number) {
        super (message);
        this.number = number;
    }

    public CasementException(String message, Throwable cause) {
        super (message, cause);
    }

    public CasementException(Throwable cause) {
        super (cause);
    }
}
