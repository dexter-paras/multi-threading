package client;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import interf.PaymentProcessor;

/* Constructor Injection*/
public class GooglePaymentServlet {

    PaymentProcessor processor;

    @Inject
    public GooglePaymentServlet(@Named("GooglePay") PaymentProcessor paymentProcessor){
        this.processor =paymentProcessor;
    }

    public void doPayment(){
        processor.processPayment();
    }

}
