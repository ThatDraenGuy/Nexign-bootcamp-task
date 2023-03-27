package draen.printer;

import draen.data.domain.subscriber.Subscriber;
import draen.io.MessageManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class PrintManager {
    private final MessageManager messageManager;
    private final String outputDir;
    private final Printer<Subscriber> subscriberPrinter = new SubscriberPrinter();

    public PrintManager(MessageManager messageManager, String outputDir) {
        this.messageManager = messageManager;
        this.outputDir = outputDir;
    }

    public void printAll(Iterator<Subscriber> subscribers) {
        while (subscribers.hasNext()) {
            Subscriber subscriber = subscribers.next();
            String phoneNumber = subscriber.getPhoneNumber();

            try {
                File file = new File(outputDir, "report-" + phoneNumber);
                PrintWriter writer = new PrintWriter(file);
                subscriberPrinter.print(subscriber, writer);
                writer.close();
            } catch (IOException e) {
                messageManager.println(e.getMessage());
            }
        }
    }
}
