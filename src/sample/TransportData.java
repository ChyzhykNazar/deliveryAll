package sample;

public class TransportData {
    private int idTransportData;
    private Car car;
    private Motobike motoBike;
    private Bike bike;

    public TransportData(Car car, Motobike motoBike, Bike bike) {
        this.car = car;
        this.motoBike = motoBike;
        this.bike = bike;
    }

    public TransportData(){}

    public int getIdTransportData() {
        return idTransportData;
    }

    public Car getCar() {
        return car;
    }

    public Motobike getMotoBike() { return motoBike; }

    public Bike getBike() {
        return bike;
    }

    public void setIdTransportData(int idTransportData) {
        this.idTransportData = idTransportData;
    }


    public void setCar(Car car) {
        this.car = car;
    }

    public void setMotoBike(Motobike motoBike) { this.motoBike = motoBike; }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

}
