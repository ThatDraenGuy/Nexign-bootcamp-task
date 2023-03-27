package draen.printer;

import draen.data.domain.call.CallReport;

import java.io.PrintWriter;
import java.text.*;
import java.time.format.DateTimeFormatter;

public class CallReportPrinter implements Printer<CallReport> {
    private final DurationPrinter durationPrinter = new DurationPrinter();
    private final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(" yyyy-MM-dd HH:mm:ss ");
    private final NumberFormat costFormat = new DecimalFormat("  0.00 ");


    @Override
    public void print(CallReport report, PrintWriter writer) {
        printColumnSeparator(writer);
        writer.print("     " + report.getCallInfo().getCallType().getCode() + "    ");
        printColumnSeparator(writer);
        writer.print(dateTimeFormat.format(report.getCallInfo().getStartTime()));
        printColumnSeparator(writer);
        writer.print(dateTimeFormat.format(report.getCallInfo().getEndTime()));
        printColumnSeparator(writer);
        durationPrinter.print(report.getCallInfo().getDuration(), writer);
        printColumnSeparator(writer);
        writer.print(costFormat.format(report.getCost()));
        printColumnSeparator(writer);
        writer.println();
    }
    private void printColumnSeparator(PrintWriter writer) {
        writer.print('|');
    }
}
