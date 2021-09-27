package part2_explicitprovider;

import javax.inject.Provider;
import java.time.LocalTime;

/* Class responsible for providing run-time binding of objects*/
public class DiscountProvider implements Provider<Discountable> {

    // Giving default NightOwnDiscount to all customers without any logic
    /*
    public Discountable get() {
        return new NightOwlDiscount();
    }
    */

    public Discountable get() {
        int hour = LocalTime.now().getHour();

        if (isEarlyMorning(hour)) {
            return new EarlyBirdDiscount();
        } else if (isLateAtNight(hour)) {
            return new NightOwlDiscount();
        }

        return new NoDiscount();
    }

    private boolean isEarlyMorning(int currentHour) {
        return (currentHour >= 5 && currentHour <= 9);
    }

    private boolean isLateAtNight(int currentHour) {
        return (currentHour >= 0 && currentHour <= 4);
    }
}
