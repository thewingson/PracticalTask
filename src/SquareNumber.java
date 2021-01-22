public class SquareNumber {

    private Integer number;
    private Integer square;
    private boolean isEven;

    public SquareNumber() {
    }

    public SquareNumber(Integer number, Integer square) {
        this.number = number;
        this.square = square;
        checkForEven();
    }

    public Integer getNumber() {
        return number;
    }

    /**
     * Setter for number.
     *
     * @implNote if number changes, square and isEven flag will be changed too.
     */
    public void setNumber(Integer number) {
        this.number = number;
        this.square = number * number;
        checkForEven();
    }

    public Integer getSquare() {
        return square;
    }

    public boolean isEven() {
        return isEven;
    }

    /**
     * Method checks for isEven flag.
     *
     * @implNote accessible only for internal sources.
     */
    private void checkForEven() {
        this.isEven = this.square % 2 == 0;
    }

    @Override
    public String toString() {
        return "SquareNumber{" +
                "number=" + number +
                ", square=" + square +
                ", isEven=" + isEven +
                '}';
    }
}
