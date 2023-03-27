package draen.io;

import java.io.*;
import java.util.stream.Stream;

public class CdrFilesReader {
    private final InputStream source;

    public CdrFilesReader(String sourcePath) throws FileNotFoundException {
        this.source = getClass().getClassLoader().getResourceAsStream(sourcePath);
        if (source == null) throw new FileNotFoundException();
    }

    public Stream<String> getLines() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(source));
        return bufferedReader.lines();
    }
}
