package client;

import com.google.inject.Inject;
import service.ExampleService;

// Field Injection
public class Client_FieldInjection {

    @Inject
    public final ExampleService service;

    Client_FieldInjection(ExampleService service){
        this.service=service;
    }
}
