public class Car {
    private String model;
    private String color;
    private int doors;
    private boolean convertible;

    public Car() {
    }

    public Car(String model, String color, int doors, boolean convertible) {
        this.model = model;
        this.color = color;
        this.doors = doors;
        this.convertible = convertible;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }
}
