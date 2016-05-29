package murach.test;


@SuppressWarnings("serial")
public class TestException extends Exception {

    public TestException() {
    }

    public TestException(String message) {
        super(message);
    }

    public TestException(Throwable cause) {
        super(cause);
    }
}
