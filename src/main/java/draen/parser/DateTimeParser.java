package draen.parser;

import draen.exceptions.ParseException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeParser implements Parser<LocalDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    @Override
    public LocalDateTime parse(String string) throws ParseException {
        try {
            return LocalDateTime.parse(string, formatter);
        } catch (DateTimeParseException e) {
            throw new ParseException(e.getMessage());
        }
    }
}
