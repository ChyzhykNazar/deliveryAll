package sample;

public class Motobike {
    private int idMotoBike;
    private String brand;
    private String color;
    private String number;

    public int getIdMotoBike() {
        return idMotoBike;
    }

    public String getBrand() {
        return brand;
    }

    public String getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setIdMotoBike(int idMotoBike) {
        this.idMotoBike = idMotoBike;
    }
}
