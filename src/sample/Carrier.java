package sample;

public class Carrier {
    private int idCarrier;
    private int idTransportData;
    private PersonalData personalData;
    private TransportData transportData;

    public int getIdCarrier() {
        return idCarrier;
    }

    public int getIdTransportData() {
        return idTransportData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public TransportData getTransportData() {
        return transportData;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public void setIdTransportData(int idTransportData) {
        this.idTransportData = idTransportData;
    }

    public void setTransportData(TransportData transportData) {
        this.transportData = transportData;
    }
}
