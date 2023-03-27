package draen.data.application;

import draen.data.domain.cdr.CdrFile;
import draen.io.CdrFilesReader;
import draen.io.MessageManager;
import draen.parser.Parser;
import draen.printer.PrintManager;

import draen.parser.CdrFileParser;

public class ApplicationContext {
    private final CdrFilesReader cdrFilesReader;
    private final Parser<CdrFile> cdrFileParser;
    private final PrintManager printManager;
    private final SubscriberStorage subscriberStorage;
    private final TariffStorage tariffStorage;
    private final MessageManager messageManager;

    public ApplicationContext(CdrFilesReader cdrFilesReader, CdrFileParser cdrFileParser,
                              PrintManager printManager, SubscriberStorage subscriberStorage,
                              TariffStorage tariffStorage, MessageManager messageManager) {
        this.cdrFilesReader = cdrFilesReader;
        this.cdrFileParser = cdrFileParser;
        this.printManager = printManager;
        this.subscriberStorage = subscriberStorage;
        this.tariffStorage = tariffStorage;
        this.messageManager = messageManager;
    }

    public CdrFilesReader getCdrFilesReader() {
        return cdrFilesReader;
    }

    public Parser<CdrFile> getCdrFileParser() {
        return cdrFileParser;
    }

    public PrintManager getPrintManager() {
        return printManager;
    }

    public SubscriberStorage getSubscriberStorage() {
        return subscriberStorage;
    }

    public TariffStorage getTariffStorage() {
        return tariffStorage;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }
}
