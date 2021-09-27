package part2_explicitprovider;

public class NightOwlDiscount implements Discountable {
    public double getDiscount() {
        return 0.35;
    }
}
