package draen.parser;

import draen.data.domain.call.CallType;
import draen.data.domain.cdr.CdrFile;
import draen.exceptions.ParseException;

import java.time.LocalDateTime;

public class CdrFileParser implements Parser<CdrFile> {
    private final Parser<CallType> callTypeParser = new CallTypeParser();
    private final Parser<LocalDateTime> dateTimeParser = new DateTimeParser();
    @Override
    public CdrFile parse(String string) throws ParseException {
        String[] elements = string.split(", ");

        if (elements.length != 5) throw new ParseException("Invalid string");

        String phoneNumber = elements[1];
        CallType callType = callTypeParser.parse(elements[0]);
        LocalDateTime startTime = dateTimeParser.parse(elements[2]);
        LocalDateTime endTime = dateTimeParser.parse(elements[3]);
        String tariffCode = elements[4];

        return new CdrFile(
                phoneNumber, callType, startTime, endTime, tariffCode
        );
    }
}
