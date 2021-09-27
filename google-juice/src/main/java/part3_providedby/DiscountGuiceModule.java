package part3_providedby;

import com.google.inject.AbstractModule;

// When ProvidedBy is used, there is no explicit configuration required by module
public class DiscountGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        // bind interface to Provider(which has logic to choose what implementation)
        //bind(Discountable.class).toProvider(DiscountProvider.class);
    }

}
