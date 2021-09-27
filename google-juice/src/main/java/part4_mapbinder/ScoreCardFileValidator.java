package part4_mapbinder;

public class ScoreCardFileValidator implements FileValidator {

    @Override
    public boolean validateFile(String fileName) {
        System.out.println("validateFile() called of ScoreCardFileValidator ");
        return false;
    }
}
