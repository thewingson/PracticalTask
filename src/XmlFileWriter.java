import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.io.FileNotFoundException;

public class XmlFileWriter extends AbstractFileWriter {

    private File file;

    public XmlFileWriter() throws FileNotFoundException {
        super();
        this.file = new File(this.fileName);
    }

    @Override
    void write(CustomGenericArray<?> genericArray) {
//        for (SquareNumber squareNumber : genericArray.getAll()) {
//            String tempString = squareNumber.toString() + System.lineSeparator();
//            try {
//                outputStream.write(tempString.getBytes());
//            } catch (IOException e) {
//                throw new RuntimeException(CommonMessages.ERROR_AT_WRITING);
//            }
//        }

        try {
            JAXBContext context = JAXBContext.newInstance(SquareNumber.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            for (SquareNumber squareNumber : genericArray.getAll()) {
                marshaller.marshal(squareNumber, file);
            }
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
