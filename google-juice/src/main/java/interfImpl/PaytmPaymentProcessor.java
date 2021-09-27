package interfImpl;

import interf.PaymentProcessor;

public class PaytmPaymentProcessor implements PaymentProcessor {
    public String processPayment() {
        return "Payment processed by Paytm";
    }
}
