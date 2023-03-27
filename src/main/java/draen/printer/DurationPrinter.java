package draen.printer;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;

public class DurationPrinter implements Printer<Duration> {
    private final NumberFormat intFormat = new DecimalFormat("00");
    @Override
    public void print(Duration item, PrintWriter writer) {
        int hours = item.toHoursPart();
        int minutes = item.toMinutesPart();
        int seconds = item.toSecondsPart();
        writer.print(" " +
                intFormat.format(hours) + ":" +
                intFormat.format(minutes) + ":" +
                intFormat.format(seconds) + " ");
    }
}
