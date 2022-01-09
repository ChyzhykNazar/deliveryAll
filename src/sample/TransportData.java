package sample;

public class TransportData {
    private int idTransportData;
    private Car car;

    public TransportData(Car car) {
        this.car = car;
    }

    public TransportData(){}

    public int getIdTransportData() {
        return idTransportData;
    }

    public Car getCar() {
        return car;
    }

    public void setIdTransportData(int idTransportData) {
        this.idTransportData = idTransportData;
    }

    public void setCar(Car car) {
        this.car = car;
    }


}
