package part3_providedby;

import com.google.inject.ProvidedBy;

@ProvidedBy(DiscountProvider.class)
public interface Discountable {
    double getDiscount();
}
