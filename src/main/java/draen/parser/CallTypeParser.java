package draen.parser;

import draen.data.domain.call.CallType;
import draen.exceptions.ParseException;

public class CallTypeParser implements Parser<CallType> {
    @Override
    public CallType parse(String string) throws ParseException {
        switch (string) {
            case "01": return CallType.OUTGOING;
            case "02": return CallType.INCOMING;
            default: throw new ParseException("Invalid call type!");
        }
    }
}
