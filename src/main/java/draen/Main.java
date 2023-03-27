package draen;

import draen.application.ApplicationController;
import draen.data.application.ApplicationContext;
import draen.data.application.SubscriberStorage;
import draen.data.application.TariffStorage;
import draen.io.CdrFilesReader;
import draen.io.MessageManager;
import draen.printer.PrintManager;
import draen.parser.CdrFileParser;
import draen.tariff.MinuteTariff;
import draen.tariff.RegularTariff;
import draen.tariff.UnlimitedTariff;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        final String source = "cdr.txt";
        final String outputDir = "reports";

        try {
            MessageManager messageManager = new MessageManager();
            PrintManager printManager = new PrintManager(
                    messageManager,
                    outputDir
            );
            TariffStorage tariffStorage = new TariffStorage();
            tariffStorage.add(
                    new UnlimitedTariff(),
                    new RegularTariff(),
                    new MinuteTariff()
            );
            ApplicationContext context = new ApplicationContext(
                    new CdrFilesReader(source),
                    new CdrFileParser(),
                    printManager,
                    new SubscriberStorage(),
                    tariffStorage,
                    messageManager
            );
            ApplicationController controller = new ApplicationController(context);
            controller.handle();
        } catch (FileNotFoundException ignored) {}
    }
}