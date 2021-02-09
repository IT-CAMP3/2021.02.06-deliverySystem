package pl.camp.it.delivery.system.model.view;

import pl.camp.it.delivery.system.model.DeliveryAddress;

public class SendShipping {
    private DeliveryAddress sender;
    private DeliveryAddress receiver;

    public SendShipping() {
    }

    public SendShipping(DeliveryAddress sender, DeliveryAddress receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public DeliveryAddress getSender() {
        return sender;
    }

    public void setSender(DeliveryAddress sender) {
        this.sender = sender;
    }

    public DeliveryAddress getReceiver() {
        return receiver;
    }

    public void setReceiver(DeliveryAddress receiver) {
        this.receiver = receiver;
    }
}
