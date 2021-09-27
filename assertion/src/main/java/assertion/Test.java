package assertion;

import com.amazon.accesspointperformanceservice.assertion.jar.AssertUtil;

public class Test {

    public static void main(String[] args) {

        boolean isPassed =false;

        //AssertUtil.setExceptionClassName("com.amazon.accesspointperformanceservice.assertion.AcquireCommonException");

        String fileType = null;

        AssertUtil.notNull(fileType, AppsCommonResultCode.FILE_TYPE_NOT_NULL,"Invalid FileType");

    }

}
