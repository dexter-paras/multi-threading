package part4_mapbinder;

public class PerformanceMetricsFileValidator implements FileValidator {

    @Override
    public boolean validateFile(String fileName) {
        System.out.println("validateFile() called of PerformanceMetricsFileValidator ");
        return true;
    }
}
