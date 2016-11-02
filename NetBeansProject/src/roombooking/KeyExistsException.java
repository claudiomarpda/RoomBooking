package roombooking;

public class KeyExistsException extends Exception {

    /**
     * Creates a new instance of <code>KeyExistsException</code> without detail
     * message.
     */
    public KeyExistsException() {
    }

    /**
     * Constructs an instance of <code>KeyExistsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public KeyExistsException(String msg) {
        super(msg);
    }
}
