package performancemap;

public class PerformanceAggregationType {

    private PerformanceAggregationType() { throw new UnsupportedOperationException(); }

    public static final String MONTH = "MONTH";
    public static final String DAY = "DAY";
    public static final String WEEK = "WEEK";
    public static final String YEAR = "YEAR";

    private static final String[] values = {
            MONTH, DAY, WEEK, YEAR
    };

    public static String[] values() {
        return values;
    }
}