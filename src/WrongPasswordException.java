public class WrongPasswordException extends IllegalArgumentException {
    public WrongPasswordException() {
     super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
