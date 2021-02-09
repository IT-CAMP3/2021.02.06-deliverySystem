package pl.camp.it.delivery.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.delivery.system.model.DeliveryAddress;
import pl.camp.it.delivery.system.model.Shipping;
import pl.camp.it.delivery.system.model.ShippingStatus;
import pl.camp.it.delivery.system.model.view.SendShipping;
import pl.camp.it.delivery.system.serives.IShippingService;
import pl.camp.it.delivery.system.utils.ShipmentUtils;

@Controller
public class SendShippingController {

    @Autowired
    IShippingService shippingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sendShipping(Model model) {

        model.addAttribute("sendShipping", new SendShipping());

        return "sendShipping";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String receiveShipping(@ModelAttribute SendShipping sendShipping) {
        Shipping shipping = new Shipping();
        shipping.setShippingNumber(ShipmentUtils.generateShipmentNumber());
        shipping.setSender(sendShipping.getSender());
        shipping.setRecipient(sendShipping.getReceiver());
        shipping.setStatus(ShippingStatus.SHIP);

        this.shippingService.persist(shipping);

        //TODO przeglądanie paczki
        return "sendShipping";
    }
}
