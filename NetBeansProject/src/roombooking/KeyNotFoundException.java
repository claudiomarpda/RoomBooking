package roombooking;

/**
 * 
 * When some key is not found in the database.
 */
public class KeyNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>KeyExistsException</code> without detail
     * message.
     */
    public KeyNotFoundException() {
    }

    /**
     * Constructs an instance of <code>KeyExistsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public KeyNotFoundException(String msg) {
        super(msg);
    }
}
