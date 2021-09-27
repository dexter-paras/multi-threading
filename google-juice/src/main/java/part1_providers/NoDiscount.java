package part1_providers;

public class NoDiscount implements Discountable {
    public double getDiscount() {
        return 0;
    }
}
