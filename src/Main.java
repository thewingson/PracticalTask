import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    private static int[] squareArray;

    public static void main(String[] args) {
        initFields();

        System.out.println("Please, enter desired number between 1 and 100:");
        int desiredNum;
        try {
            desiredNum = in.nextInt();
            if (desiredNum < 1 || desiredNum > 100) {
                throw new IllegalStateException(CommonMessages.NUMBER_OUT_OF_RANGE);
            }
            printNumbers(desiredNum);
        } catch (InputMismatchException e){
            throw new IllegalArgumentException(CommonMessages.ILLEGAL_TYPE_OF_INPUT);
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
}
