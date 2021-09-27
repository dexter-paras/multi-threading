package main;

import client.Client_ConstructorInjection;
import client.GooglePaymentServlet;
import com.google.inject.Guice;
import com.google.inject.Injector;
import controller.PingController;
import interf.PaymentProcessor;
import interfImpl.GooglePaymentProcessor;
import interfImpl.LWATokenGenerator;
import interfImpl.PaytmPaymentProcessor;
import service.ExampleService;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        System.out.println(injector.getAllBindings());
        ExampleService service = injector.getInstance(ExampleService.class);
        Client_ConstructorInjection client = injector.getInstance(Client_ConstructorInjection.class);
        System.out.println(client.service == service);
        service.greet();

        /* Example 2 - Giving explicit binding in module classes */
        LWATokenGenerator obj = injector.getInstance(LWATokenGenerator.class);

       PingController pingController= injector.getInstance(PingController.class);
       pingController.get();

        /* Example 3 - Binding Annotations
           Useful when you need multiple bindings for same type
        */

        PaymentProcessor processor = injector.getInstance(PaytmPaymentProcessor.class);
        System.out.println(processor.processPayment());
    }
}
