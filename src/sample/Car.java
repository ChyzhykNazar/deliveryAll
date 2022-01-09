package sample;

public class Car {
    private int idCar;
    private String type;
    private String color;
    private String  brand;
    private String number;

    public Car(){}

    public Car(String type, String color, String  brand, String number){
        this.type = type;
        this.color = color;
        this.brand = brand;
        this.number = number;
    }

    public Car(int idCar, String type, String color, String  brand, String number){
        this.idCar = idCar;
        this.type = type;
        this.color = color;
        this.brand = brand;
        this.number = number;
    }

    public int getIdCar() {
        return idCar;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getNumber() {
        return number;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
