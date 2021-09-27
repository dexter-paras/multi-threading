package assertion.jar;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Map;

/**
 * <p><b>How to use：</b>
 * <ul>
 * <li>Define the anonymous bean of AssertUtil locally.
 * <li>Inject the value of the property exceptionClassName as per Biz into the anonymous bean.
 *
 * <li> ExceptionClass must be a subclass of AssertionException,
 * and implement the construction method with error description parameters.
 * </ul>
 *
 */
public class AssertUtil {

    /**
     * Class name of the exception class
     */
    private static String exceptionClassName;

    /**
     * Exception object construction method
     */
    private static Constructor constructor;

    /**
     * Assert that the value of the expression is true, otherwise a specified error message will be thrown.
     * @param expValue
     * @param resultCode
     * @param objs
     */
    public static void isTrue(final boolean expValue, final AssertionResultCode resultCode, final Object... objs) {

        if (!expValue) {

            AssertionException exception = null;
            String logString = getLogString(objs);
            String resultMsg = StringUtils.isBlank(logString) ? resultCode.getResultMsg() : logString;

            try {
                exception = (AssertionException) constructor.newInstance(resultMsg);
            } catch (Throwable e) {
                throw new IllegalArgumentException("AssertUtil has not been initiallized correctly![exceptionClassName="
                        + exceptionClassName + ",resultCode=" + resultCode + ",resultMsg=" + resultMsg + "]", e);
            }

            exception.setResultCode(resultCode);
            throw exception;
        }
    }

    /**
     * Assert that the value of the expression is true, otherwise a specified error message will be thrown
     *
     * Add assertion callback processing, even if the assertion is successful, a callback object will be created,
     * which may increase system performance overhead, so use it with caution
     *
     * @param expValue
     * @param resultCode
     * @param callback
     */
    public static void isTrue(final boolean expValue, final AssertionResultCode resultCode,
                              AssertionCallback callback) {

        if (expValue) {
            return;
        }

        callback.failAction();
        isTrue(expValue, resultCode);
    }

    /**
     * Assert that the value of the expression is false, otherwise the specified error message will be thrown.
     * @param expValue
     * @param resultCode
     * @param objs
     */
    public static void isFalse(final boolean expValue, final AssertionResultCode resultCode, final Object... objs) {
        isTrue(!expValue, resultCode, objs);
    }


    /**
     * Assert that the two objects are equal, otherwise throw the specified error message.
     * @param obj1
     * @param obj2
     * @param resultCode
     * @param objs
     */
    public static void equals(final Object obj1, final Object obj2, final AssertionResultCode resultCode,
                              final Object... objs) {

        isTrue(obj1 == null ? obj2 == null : obj1.equals(obj2), resultCode, objs);
    }

    /**
     * Assert that the two objects are not equal, otherwise throw the specified error message.
     * @param obj1
     * @param obj2
     * @param resultCode
     * @param objs
     */
    public static void notEquals(final Object obj1, final Object obj2, final AssertionResultCode resultCode,
                                 final Object... objs) {

        isTrue(obj1 == null ? obj2 != null : !obj1.equals(obj2), resultCode, objs);
    }

    /**
     * Assert that the two objects are exactly the same and same reference, otherwise throw the specified error message.
     * @param base
     * @param target
     * @param resultCode
     * @param objs
     */
    public static void is(final Object base, final Object target, final AssertionResultCode resultCode,
                          final Object... objs) {

        isTrue(base == target, resultCode, objs);
    }


    /**
     * Assert that the two objects are not the same, otherwise throw the specified error message.
     * @param base
     * @param target
     * @param resultCode
     * @param objs
     */
    public static void isNot(final Object base, final Object target, final AssertionResultCode resultCode,
                             final Object... objs) {

        isTrue(base != target, resultCode, objs);
    }

    /**
     * Assert that the specified object is in the container. Otherwise, the specified error message will be thrown.
     * @param base
     * @param collection
     * @param resultCode
     * @param objs
     */
    public static void contains(final Object base, final Collection<?> collection, final AssertionResultCode resultCode,
                                final Object... objs) {
        notEmpty(collection, resultCode, objs);
        isTrue(collection.contains(base), resultCode, objs);
    }

    /**
     * Assert that the specified object is in the container. Otherwise, the specified error message will be thrown.
     * @param base
     * @param collection
     * @param resultCode
     * @param objs
     */
    public static void in(final Object base, final Object[] collection, final AssertionResultCode resultCode,
                          final Object... objs) {

        notNull(collection, resultCode, objs);

        boolean hasEqual = false;
        for (Object obj2 : collection) {

            if (base == obj2) {
                hasEqual = true;
                break;
            }
        }

        isTrue(hasEqual, resultCode, objs);
    }

    /**
     * Assert that the specified object is not in the container. Otherwise, the specified error message will be thrown.
     *
     * Note - here = refers to "=" and not object equals
     * @param base
     * @param collection
     * @param resultCode
     * @param objs
     */
    public static void notIn(final Object base, final Object[] collection, final AssertionResultCode resultCode,
                             final Object... objs) {

        if (null == collection) {
            return;
        }

        for (Object obj2 : collection) {
            isTrue(base != obj2, resultCode, objs);
        }
    }

    /**
     *
     * @param str
     * @param resultCode
     * @param objs
     */
    public static void blank(final String str, final AssertionResultCode resultCode, final Object... objs) {

        isTrue(StringUtils.isBlank(str), resultCode, objs);
    }

    /**
     *
     * @param str
     * @param resultCode
     * @param objs
     */
    public static void notBlank(final String str, final AssertionResultCode resultCode, final Object... objs) {

        isTrue(StringUtils.isNotBlank(str), resultCode, objs);
    }

    /**
     *
     * @param object
     * @param resultCode
     * @param objs
     */
    public static void isNull(final Object object, final AssertionResultCode resultCode, final Object... objs) {

        isTrue(object == null, resultCode, objs);
    }

    /**
     *
     * @param object
     * @param resultCode
     * @param objs
     */
    public static void notNull(final Object object, final AssertionResultCode resultCode, final Object... objs) {

        isTrue(object != null, resultCode, objs);
    }

    /**
     *
     * @param collection
     * @param resultCode
     * @param objs
     */
    public static void notEmpty(final Collection collection, final AssertionResultCode resultCode,
                                final Object... objs) {

        isTrue(!CollectionUtils.isEmpty(collection), resultCode, objs);
    }

    /**
     *
     * @param collection
     * @param resultCode
     * @param objs
     */
    public static void empty(final Collection collection, final AssertionResultCode resultCode, final Object... objs) {
        isTrue(CollectionUtils.isEmpty(collection), resultCode, objs);
    }

    /**
     *
     * @param map
     * @param resultCode
     * @param objs
     */
    public static void notEmpty(final Map map, final AssertionResultCode resultCode, final Object... objs) {

        isTrue(!CollectionUtils.isEmpty(map), resultCode, objs);
    }

    /**
     *
     * @param map
     * @param resultCode
     * @param objs
     */
    public static void empty(final Map map, final AssertionResultCode resultCode, final Object... objs) {

        isTrue(CollectionUtils.isEmpty(map), resultCode, objs);
    }

    // ~~~ Internal Methods

    /**
     * Generate a string for output to the log
     *
     * @param objs
     * @return
     */
    private static String getLogString(Object... objs) {
        StringBuilder log = new StringBuilder();

        for (Object o : objs) {
            log.append(o);
        }
        return log.toString();
    }

    /**
     * Initialize AssertUtil Configuration
     */
    private static void initConfig() {

        Class exceptionClassTmp = null;

        // 1. Load Biz Exception class
        if (StringUtils.isBlank(exceptionClassName)) {
            throw new IllegalArgumentException("exceptionClassName has not set!");
        }

        try {
            exceptionClassTmp = Class.forName(exceptionClassName);
        } catch (Throwable e) {
            throw new IllegalArgumentException(
                    "loading exceptionClass failed![exceptionClassName=" + exceptionClassName + "]", e);
        }

        // Must be a subclass of AssertException
        if (!AssertionException.class.isAssignableFrom(exceptionClassTmp)) {
            throw new IllegalArgumentException(
                    "illegal exceptionClass type, must be the subclass of AssertionException![exceptionClassName="
                            + exceptionClassName + "]");
        }

        Constructor constructorTmp = null;

        // 2. Get the construction method
        try {
            constructorTmp = exceptionClassTmp.getConstructor(String.class);
        } catch (Throwable e) {
            throw new IllegalArgumentException(
                    "constructor method not found![exceptionClassName=" + exceptionClassName + "]", e);
        }

        constructor = constructorTmp;
    }

    /**
     * Setter method for property <tt>exceptionClassName</tt>.
     *
     * @param exceptionClassName value to be assigned to property exceptionClassName
     */
    @Inject
    @Named("com.amazon.accesspointperformanceservice.assertion.AppsCommonException")
    public static void setExceptionClassName(String exceptionClassName) {
        AssertUtil.exceptionClassName = exceptionClassName;
        initConfig();
    }
}
