import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class AbstractFileWriter {

    protected String fileName = CommonMessages.PATH_TO_THE_TEXTFILE;
    protected OutputStream outputStream;

    /**
     * Simple simple with no arguments.
     *
     * @throws FileNotFoundException if file not found or access denied
     *                          this will be thrown.
     */
    public AbstractFileWriter() throws FileNotFoundException {
        this.outputStream = new FileOutputStream(this.fileName);
    }


    /**
     * Writes data to file
     *
     * @param genericArray
     */
    abstract void write(CustomGenericArray<?> genericArray);

    /**
     * Closes output stream.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void close() throws IOException {
        this.outputStream.close();
    }

}
