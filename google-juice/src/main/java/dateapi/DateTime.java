package dateapi;

import lombok.Value;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Value
@Accessors(fluent = true)
public class DateTime implements Timed {
    LocalDateTime dateTime;
}
