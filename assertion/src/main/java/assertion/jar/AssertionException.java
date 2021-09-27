package assertion.jar;

/**
 * Assert Util exception base class. All exception objects that use AssertUtil need to inherit this object.
 * 
 * Note: Subclasses inherit this exception object and must implement the default construction method and
 * the construction method with exception description parameters. That is: XXXX (String msg).
 *
 * In addition, the result code used in the subclass must implement the AssertionResultCode interface.
 *
 * @version $Id: AssertionException.java
 */
public abstract class AssertionException extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 7820674757672180049L;

    /**
     * Set error enumeration information
     * 
     * @param resultCode error Code
     */
    public abstract void setResultCode(AssertionResultCode resultCode);

    /**
     *
     */
    public AssertionException() {

    }

    /**
     * Construct an <code>AssertionException</code> object.
     *
     * @param msg           Exception description
     */
    public AssertionException(String msg) {
        super(msg);
    }

    /**
     * Construct an <code>AssertionException</code> object.
     *
     * @param cause         Abnormal Exception
     */
    public AssertionException(Throwable cause) {
        super(cause);
    }

    /**
     * Construct an <code>AssertionException</code> object.
     *
     * @param msg           Exception description
     * @param cause         Abnormal
     */
    public AssertionException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
