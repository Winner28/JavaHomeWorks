package Module_5_Exceptions.Task_One;

public class UserInputException extends RuntimeException {
    private String message;

    public UserInputException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Exception: " + message;
    }
}
