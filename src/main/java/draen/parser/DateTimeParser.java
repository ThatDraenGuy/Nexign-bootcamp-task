package draen.parser;

import draen.exceptions.ParseException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParser implements Parser<LocalDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
    @Override
    public LocalDateTime parse(String string) throws ParseException {
        return LocalDateTime.parse(string, formatter);
    }
}
