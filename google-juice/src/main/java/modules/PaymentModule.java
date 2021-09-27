package modules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import interf.PaymentProcessor;
import interfImpl.GooglePaymentProcessor;

public class PaymentModule extends AbstractModule {

    /* PaymentProcessor which have same name as "GooglePay" -> bind to GooglePaymentProcessor */
    @Override
    protected void configure() {
        bind(PaymentProcessor.class).annotatedWith(Names.named("GooglePay")).to(GooglePaymentProcessor.class);
    }
}
