package draen.application;

import draen.data.application.ApplicationContext;
import draen.data.domain.call.CallInfo;
import draen.data.domain.cdr.CdrFile;
import draen.data.domain.call.CallReport;
import draen.data.domain.subscriber.Subscriber;
import draen.exceptions.ParseException;
import draen.exceptions.TariffCodeException;
import draen.tariff.Tariff;

public class ApplicationController {
    private final ApplicationContext ctx;

    public ApplicationController(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public void handle() {
        ctx.getCdrFilesReader().getLines().forEach(line -> {
            try {
                handleLine(line);
            } catch (ParseException | TariffCodeException e) {
                ctx.getMessageManager().println(e.getMessage());
            }
        });
        ctx.getPrintManager().printAll(ctx.getSubscriberStorage().getAll());
    }

    private void handleLine(String line) throws ParseException, TariffCodeException {
        CdrFile cdrFile;
        cdrFile = ctx.getCdrFileParser().parse(line);
        if (! ctx.getTariffStorage().contains(cdrFile.getTariffCode()))
            throw new TariffCodeException("Unsupported tariff: " + cdrFile.getTariffCode());
        Tariff tariff = ctx.getTariffStorage().get(cdrFile.getTariffCode());
        if (! ctx.getSubscriberStorage().contains(cdrFile.getPhoneNumber()))
            ctx.getSubscriberStorage().add(new Subscriber(cdrFile, tariff.getTariffCost()));
        handleCdrFile(cdrFile);
    }

    private void handleCdrFile(CdrFile cdrFile) {
        Subscriber subscriber = ctx.getSubscriberStorage().get(cdrFile.getPhoneNumber());
        CallInfo callInfo = new CallInfo(cdrFile);
        double cost = ctx.getTariffStorage().get(subscriber.getTariffCode()).getCallCost(subscriber, callInfo);
        CallReport callReport = new CallReport(callInfo, cost);
        subscriber.addReport(callReport);
    }
}
