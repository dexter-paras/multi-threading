package dateapi;

import com.google.common.collect.ImmutableMap;
import lombok.Builder;
import lombok.Value;

import lombok.experimental.Accessors;
import java.util.Map;

@Value
@Builder
@Accessors(fluent = true)
public class TimeRange<T extends Timed> {
    T from;
    T to;

    public Type type() {
        return TypeResolver.map.get(from.getClass());
    }

    public enum Type {
        WEEK, DAY, MONTH, YEAR
    }

    static class TypeResolver {
        static Map<Class<?>, Type> map = ImmutableMap.<Class<?>, Type>builder()
                .put(Week.class, Type.WEEK)
                .put(Day.class, Type.DAY)
                .put(Month.class, Type.MONTH)
                .put(Year.class, Type.YEAR)
                .build();
    }
}

