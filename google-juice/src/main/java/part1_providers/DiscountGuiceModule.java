package part1_providers;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.time.LocalTime;

    /* Module including Provider logic means when guice sees @Provides,
       it automatically bind Discountable to call get() to give runtime dependency
    */

public class DiscountGuiceModule extends AbstractModule {

    @Provides
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
