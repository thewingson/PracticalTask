import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static int[] squareArray;
    private static CustomGenericArray<SquareNumber> squareNumberArray;
    private static TextFileWriter textFileWriter;
    private static XmlFileWriter xmlFileWriter;

    public static void main(String[] args) {
        initFields();

//        System.out.println("Please, enter desired number between 1 and 100:");
        int desiredNum;
        try {
//            desiredNum = in.nextInt();
//            if (desiredNum < 1 || desiredNum > 100) {
//                throw new IllegalStateException(CommonMessages.NUMBER_OUT_OF_RANGE);
//            }
//            printNumbers(desiredNum);
            copyNumbers();
//            textFileWriter = TextFileWriter.getInstance();
//            textFileWriter.write(squareNumberArray);
//            textFileWriter.close();

            xmlFileWriter = new XmlFileWriter();
            xmlFileWriter.write(squareNumberArray);
        } catch (InputMismatchException e){
            throw new IllegalArgumentException(CommonMessages.ILLEGAL_TYPE_OF_INPUT);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(CommonMessages.UNABLE_TO_OPEN_FILE);
        } catch (IOException e) {
            throw new IllegalStateException(CommonMessages.FILE_IS_UNACCESSIBLE);
        }

    }

    /**
     * Simple method for initialization of array values.
     * */
    private static void initFields() {
        squareArray = new int[100];
        for (int i = 1; i <= squareArray.length; i++) {
            squareArray[i - 1] = i * i;
        }
    }

    /**
     * Method for printing squared values.
     *
     * @param rangeEnd - last index to read to.
     * */
    private static void printNumbers(Integer rangeEnd) {
        for (int i = 0; i < rangeEnd; i++) {
            System.out.printf("(%d)^2 = %d%n", i + 1, squareArray[i]);
        }
    }

    /**
     * @see Main#printNumbers(Integer rangeEnd) overload
     *
     * @param rangeStart - start index to read from.
     * @param rangeEnd - last index to read to.
     * */
    private static void printNumbers(Integer rangeStart, Integer rangeEnd) {
        for (int i = rangeStart - 1; i < rangeEnd; i++) {
            System.out.printf("(%d)^2 = %d%n", i + 1, squareArray[i]);
        }
    }


    private static void copyNumbers() {
        squareNumberArray = new CustomGenericArray<>(SquareNumber.class, squareArray.length);
        for (int i = 0; i < squareArray.length; i++) {
            SquareNumber squareNumber = new SquareNumber(i+1, squareArray[i]);
            squareNumberArray.add(squareNumber);
        }

        for (int i = 0; i < squareNumberArray.getSize(); i++) {
            System.out.println(squareNumberArray.get(i));
        }
    }
}
