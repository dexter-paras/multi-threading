package modules;

import com.google.inject.AbstractModule;
import interf.TokenGenerator;
import interfImpl.LWATokenGenerator;

// In case of any confusion, Injector checks Explicit bindings n Module classes
public class AuthModule extends AbstractModule {

    /* Tight coupling where TokenGenerator always point to LWATokenGeneratorImpl*/
    @Override
    protected void configure() {
        bind(TokenGenerator.class).to(LWATokenGenerator.class);
    }
}
