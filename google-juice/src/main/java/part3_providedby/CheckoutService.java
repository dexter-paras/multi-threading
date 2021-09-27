package part3_providedby;

import com.google.inject.Inject;

/* 1. Using Provider to provide runtime implementation of Discountable interface
*  2. Provider helps in lazy instantiation of object which is inexpensive
*/
public class CheckoutService {

     private final Discountable discountable;
    //private final Provider<Discountable> discountable;

    @Inject
    public CheckoutService(Discountable discountable) {
    //public CheckoutService(Provider<Discountable> discountable) {
        this.discountable = discountable;
    }

    public double checkout(double shoppingCartTotal) {
        double discount = discountable.getDiscount();
        //double discount = discountable.get().getDiscount();

        double totalAfterDiscount = shoppingCartTotal - (shoppingCartTotal * discount);
        System.out.printf("%nShopping cart initially [$%.2f] with a discount of %.2f%% = [$%.2f]%n%n",
                shoppingCartTotal,
                discount * 100,
                totalAfterDiscount);

        return totalAfterDiscount;
    }
}
