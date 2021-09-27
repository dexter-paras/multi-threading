package part3_providedby;

import com.google.inject.Guice;
import com.google.inject.Injector;

/* No Module is required if we use @ProvidedBy or @ImplementedBy annotations */
public class Main {

    public static void main(String[] args) {

        Injector guice = Guice.createInjector(new DiscountGuiceModule());
        System.out.println(guice.getBindings());
        System.out.println(guice.getAllBindings());

        CheckoutService service = guice.getInstance(CheckoutService.class);
        service.checkout(100d);
    }
}
