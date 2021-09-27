/**
 * Alipay.com Inc. Copyright (c) 2004-2015 All Rights Reserved.
 */
package assertion;

import com.amazon.accesspointperformanceservice.assertion.jar.AssertionResultCode;

/**
 * APPS General Result Code
 *
 */
public enum AppsCommonResultCode implements AssertionResultCode {

    SUCCESS(ErrorLevels.INFO.name(), ErrorTypes.BIZ.name(), "000", "SUCCESS"),

    /** Invalid Parameter */
    PARAM_ILLEGAL(ErrorLevels.ERROR.name(), ErrorTypes.BIZ.name(), "001", "request param illegal"),

    /** Unknown exception */
    UNKNOW_EXCEPTION(ErrorLevels.ERROR.name(), ErrorTypes.SYSTEM.name(), "002", "unknown exception"),

    /** System Abnormal behavior **/
    SYSTEM_ERROR(ErrorLevels.ERROR.name(), ErrorTypes.SYSTEM.name(), "003", "system error"),

    FILE_TYPE_NOT_NULL(ErrorLevels.ERROR.name(), ErrorTypes.BIZ.name(), "004", "file type can't be null"),
    ;

    /** Error Level */
    private final String errorLevel;

    /** Error Type */
    private final String errorType;

    /** Result Code  */
    private final String code;

    /** Result Code Description */
    private final String description;

    /**
     *
     * @param errorLevel
     * @param errorType
     * @param code
     * @param description
     */
    AppsCommonResultCode(String errorLevel, String errorType, String code, String description) {
        this.errorLevel = errorLevel;
        this.errorType = errorType;
        this.code = code;
        this.description = description;
    }

    @Override
    public String getResultCode() {
        return code;
    }

    @Override
    public String getResultMsg() {
        return description;
    }

    @Override
    public String getErrorLevel() {
        return errorLevel;
    }

    @Override
    public String getErrorType() {
        return errorType;
    }

    public static AppsCommonResultCode getByResultCode(String resultCode) {
        for (AppsCommonResultCode code : values()) {
            if (code.getResultCode().equals(resultCode)) {
                return code;
            }
        }
        return null;
    }

}
