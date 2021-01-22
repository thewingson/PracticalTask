import java.io.FileNotFoundException;
import java.io.IOException;

public class TextFileWriter extends AbstractFileWriter {

    public TextFileWriter() throws FileNotFoundException {
        super();
    }

    public void write(CustomGenericArray<?> genericArray) throws RuntimeException {
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
