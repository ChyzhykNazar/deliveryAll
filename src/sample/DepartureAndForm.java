package sample;

public class DepartureAndForm{
    private int iddeparture;
    private String firstNameSender;
    private String lastNameSender;
    private String firstNameRecipient;
    private String lastNameRecipient;
    private String firstNameCarrier;
    private String lastNameCarrier;
    private String shippingAddress;
    private String receivingAddress;
    private String costDeparture;
    private String costParcel;
    private String contentsShipping;

    public int getIddeparture() {
        return iddeparture;
    }

    public String getFirstNameSender() {
        return firstNameSender;
    }

    public String getLastNameSender() {
        return lastNameSender;
    }

    public String getLastNameRecipient() {
        return lastNameRecipient;
    }

    public String getFirstNameRecipient() {
        return firstNameRecipient;
    }

    public String getFirstNameCarrier() {
        return firstNameCarrier;
    }

    public String getLastNameCarrier() {
        return lastNameCarrier;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getContentsShipping() {
        return contentsShipping;
    }

    public String getCostDeparture() {
        return costDeparture;
    }

    public String getCostParcel() {
        return costParcel;
    }

    public void setIddeparture(int iddeparture) {
        this.iddeparture = iddeparture;
    }

    public void setFirstNameSender(String firstNameSender) {
        this.firstNameSender = firstNameSender;
    }

    public void setFirstNameRecipient(String firstNameRecipient) {
        this.firstNameRecipient = firstNameRecipient;
    }

    public void setLastNameRecipient(String lastNameRecipient) {
        this.lastNameRecipient = lastNameRecipient;
    }

    public void setLastNameSender(String lastNameSender) {
        this.lastNameSender = lastNameSender;
    }

    public void setFirstNameCarrier(String firstNameCarrier) {
        this.firstNameCarrier = firstNameCarrier;
    }

    public void setLastNameCarrier(String lastNameCarrier) {
        this.lastNameCarrier = lastNameCarrier;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    public void setCostParcel(String costParcel) {
        this.costParcel = costParcel;
    }

    public void setCostDeparture(String costDeparture) {
        this.costDeparture = costDeparture;
    }

    public void setContentsShipping(String contentsShipping) {
        this.contentsShipping = contentsShipping;
    }
}
