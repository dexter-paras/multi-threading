package dateapi;

import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
public class Month implements Timed {
    String month;
    String year;
}
