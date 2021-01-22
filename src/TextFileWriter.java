import java.io.FileNotFoundException;
import java.io.IOException;

public class TextFileWriter extends AbstractFileWriter {

    private static volatile TextFileWriter INSTANCE;

    private TextFileWriter() throws FileNotFoundException {
        super();
    }

    public static TextFileWriter getInstance() throws FileNotFoundException {
        TextFileWriter result = INSTANCE;
        if (result != null) {
            return result;
        }
        synchronized(TextFileWriter.class) {
            if (INSTANCE == null) {
                INSTANCE = new TextFileWriter();
            }
            return INSTANCE;
        }
    }

    public synchronized void write(CustomGenericArray<?> genericArray) throws RuntimeException {
        for (SquareNumber squareNumber : genericArray.getAll()) {
            String tempString = squareNumber.toString() + System.lineSeparator();
            try {
                outputStream.write(tempString.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(CommonMessages.ERROR_AT_WRITING);
            }
        }
    }

}
