import java.lang.reflect.Array;

public class CustomGenericArray<T extends SquareNumber> {

    private T[] objectArray;
    private int index = 0;

    public CustomGenericArray(Class<T> type, int length) {
        @SuppressWarnings("unchecked") final T[] a = (T[]) Array.newInstance(type, length);
        this.objectArray = a;
    }

    public T get(int i) {
        return objectArray[i];
    }

    public void add(T element) {
        if (this.index < objectArray.length) {
            objectArray[index] = element;
            this.index++;
        }
    }

    public void addAll(T[] elements) {
        if (this.objectArray.length - this.index <= elements.length) {
            for (T element : elements) {
                add((element));
            }
            this.index += elements.length;
        }
    }

    public int getSize() {
        return this.objectArray.length;
    }

}
