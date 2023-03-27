package draen.parser;

import draen.exceptions.ParseException;

public interface Parser<T> {
    T parse(String string) throws ParseException;
}
