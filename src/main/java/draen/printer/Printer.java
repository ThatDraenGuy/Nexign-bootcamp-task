package draen.printer;

import java.io.PrintWriter;

public interface Printer<T> {
    void print(T item, PrintWriter writer);
}
