package client;

import com.google.inject.Inject;
import service.ExampleService;

// Constructor Injection
public class Client_ConstructorInjection {

    public final ExampleService service;

    @Inject
    Client_ConstructorInjection(ExampleService service){
        this.service=service;
    }
}
