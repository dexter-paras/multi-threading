package part4_mapbinder;

import com.google.inject.Inject;

public class CheckoutValidatorService {

    FileValidator validator;

    @Inject
    public CheckoutValidatorService(FileValidator validator) {
        this.validator = validator;
    }

    public boolean checkoutValidation(String fileName) {
        System.out.println("Inside CheckoutValidation");
        boolean valid = validator.validateFile(fileName);
        return valid;
    }
}
