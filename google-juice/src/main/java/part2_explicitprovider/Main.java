package part2_explicitprovider;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {

        Injector guice = Guice.createInjector(new DiscountGuiceModule());
        System.out.println(guice.getBindings());
        System.out.println(guice.getAllBindings());

        CheckoutService service = guice.getInstance(CheckoutService.class);
        service.checkout(100d);
    }
}
