package assertion.jar;

/**
 * Assertion callback interface, some actions can be triggered after the assertion fails
 */
public interface AssertionCallback {

    /**
     * After assertion fails, some action can be triggered
     */
    void failAction();

}
