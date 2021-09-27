package part2_explicitprovider;

import com.google.inject.AbstractModule;

public class DiscountGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        // bind interface to Provider(which has logic to choose what implementation)
        bind(Discountable.class).toProvider(DiscountProvider.class);
    }

}
