package draen.utils;

import java.time.Duration;

public class DurationUtils {
    public static long getMinutes(Duration duration) {
        return (long) Math.ceil(duration.toSeconds() / 60.0);
    }
}
