package part2_explicitprovider;

public class EarlyBirdDiscount implements Discountable {
    public double getDiscount() {
        return 0.25;
    }
}
