package part3_providedby;

import javax.inject.Provider;
import java.time.LocalTime;

public class DiscountProvider implements Provider<Discountable> {

    @Override
    public Discountable get() {
        int hour = LocalTime.now().getHour();

        if (isEarlyEvening(hour)) {
            return new EarlyBirdDiscount();
        } else if (isLateAtNight(hour)) {
            return new NightOwlDiscount();
        }

        return new NoDiscount();
    }

    private boolean isEarlyEvening(int currentHour) {
        return (currentHour >= 19 && currentHour <= 24);
    }

    private boolean isLateAtNight(int currentHour) {
        return (currentHour >= 0 && currentHour <= 4);
    }
}
