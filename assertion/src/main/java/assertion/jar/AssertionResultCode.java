package assertion.jar;

/**
 * Abnormal Assertion Result Code
 * 
 */
public interface AssertionResultCode {

    /**
     * Get the code corresponding to the result code。
     * 
     * @return result Code
     */
    String getResultCode();

    /**
     * Get the description information corresponding to the result code.。
     * 
     * @return Description
     */
    String getResultMsg();

    /**
     * Get Error Level
     * @return
     */
    String getErrorLevel();

    /**
     * Get Error Type
     * @return
     */
    String getErrorType();

}
