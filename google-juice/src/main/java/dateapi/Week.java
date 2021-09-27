package dateapi;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
public class Week implements Timed {
    int week;
    int year;
}
