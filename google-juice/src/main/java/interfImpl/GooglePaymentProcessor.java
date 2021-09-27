package interfImpl;

import interf.PaymentProcessor;

public class GooglePaymentProcessor implements PaymentProcessor {
    public String processPayment() {
        return "Payment processed by Google";
    }
}
