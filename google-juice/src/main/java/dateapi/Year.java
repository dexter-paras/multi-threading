package dateapi;

import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
public class Year implements Timed {
    String year;
}
