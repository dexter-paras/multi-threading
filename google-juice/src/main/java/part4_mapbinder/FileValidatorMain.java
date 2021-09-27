package part4_mapbinder;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class FileValidatorMain {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new FileValidatorGuiceModule());
        CheckoutValidatorService service = injector.getInstance(CheckoutValidatorService.class);

        service.checkoutValidation("PerformanceFile");
    }
}
