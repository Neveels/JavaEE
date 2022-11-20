public class Temperature {
    private double number;

    public Temperature(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Temperature: " + number;
    }
}
