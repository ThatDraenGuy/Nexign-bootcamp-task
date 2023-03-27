package draen.printer;

import draen.data.domain.call.CallReport;
import draen.data.domain.subscriber.Subscriber;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class SubscriberPrinter implements Printer<Subscriber> {
    private final Printer<CallReport> callReportPrinter = new CallReportPrinter();
    private final NumberFormat costFormat = new DecimalFormat("0.00");


    @Override
    public void print(Subscriber subscriber, PrintWriter writer) {
        writer.println("Tariff index: " + subscriber.getTariffCode());
        printRowSeparator(writer);
        writer.println("Report for phone number " + subscriber.getPhoneNumber() + ":");
        printRowSeparator(writer);

        writer.println("| Call Type |   Start Time        |     End Time        | Duration | Cost  |");
        printRowSeparator(writer);
        for (var report : subscriber.getReports()) {
            callReportPrinter.print(report, writer);
        }
        printRowSeparator(writer);
        writer.println("|                                           Total Cost: |     " + 
                costFormat.format(subscriber.getCost()) + " rubles |");
        printRowSeparator(writer);
    }

    private void printRowSeparator(PrintWriter writer) {
        writer.println("----------------------------------------------------------------------------");
    }
}
