package Module_5_Exceptions.Task_Two;

public class NoSuchKeyException extends RuntimeException {

    public NoSuchKeyException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "NO KEY";
    }
}
