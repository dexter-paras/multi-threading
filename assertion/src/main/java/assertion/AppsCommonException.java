/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package assertion;


import com.amazon.accesspointperformanceservice.assertion.jar.AssertionException;
import com.amazon.accesspointperformanceservice.assertion.jar.AssertionResultCode;

/**
 * General APPS CommonException
 *
 */
public class AppsCommonException extends AssertionException {

    private static final long serialVersionUID = -8342587280146078070L;

    /**
     * Result Code
     */
    private AppsCommonResultCode resultCode;

    /**
     *
     * @param resultCode
     */
    public AppsCommonException(AppsCommonResultCode resultCode) {
        super(resultCode.getResultMsg());
        this.resultCode = resultCode;
    }

    /**
     *
     * @param resultCode
     * @param errorMsg
     */
    public AppsCommonException(AppsCommonResultCode resultCode, String errorMsg) {
        super(errorMsg);
        this.resultCode = resultCode;
    }

    /**
     *
     * @param errorMsg
     */
    public AppsCommonException(String errorMsg) {
        super(errorMsg);
    }

    /**
     * Getter method for property <tt>resultCode</tt>.
     *
     * @return property value of resultCode
     */
    public AppsCommonResultCode getResultCode() {
        return resultCode;
    }

    @Override
    public void setResultCode(final AssertionResultCode resultCode) {
        this.resultCode = (AppsCommonResultCode) resultCode;
    }
}
