package part2_explicitprovider;

public class NoDiscount implements Discountable {
    public double getDiscount() {
        return 0;
    }
}
