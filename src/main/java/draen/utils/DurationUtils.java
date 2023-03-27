package draen.utils;

import java.time.Duration;

public class DurationUtils {
    public static long getMinutes(Duration duration) {
        return duration.toSeconds() / 60;
    }
}
