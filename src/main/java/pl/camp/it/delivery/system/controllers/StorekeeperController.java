package pl.camp.it.delivery.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.camp.it.delivery.system.model.Shipping;
import pl.camp.it.delivery.system.serives.IShippingService;
import pl.camp.it.delivery.system.validators.WeightValidator;

import java.util.Optional;

@Controller
@RequestMapping(value = "/storekeeper")
public class StorekeeperController {

    @Autowired
    IShippingService shippingService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "storekeeper/main";
    }

    @RequestMapping(value = "/shipment", method = RequestMethod.GET)
    public String shipmentIdForm() {
        return "storekeeper/shipmentNumberForm";
    }

    @RequestMapping(value = "/shipment", method = RequestMethod.POST)
    public String shipmentId(@RequestParam String number) {
        return "redirect:/storekeeper/shipment/"+number;
    }

    @RequestMapping(value = "/shipment/{number}", method = RequestMethod.GET)
    public String shipmentForm(@PathVariable int number, Model model) {
        Optional<Shipping> shipping = this.shippingService.getShippingByNumber(number);
        if(shipping.isPresent()) {
            model.addAttribute("shipping", shipping.get());
            return "storekeeper/shipmentForm";
        } else {
            return "redirect:/storekeeper/shipment";
        }
    }

    @RequestMapping(value = "/shipment/{number}", method = RequestMethod.POST)
    public String shipmentForm(@RequestParam String weight, @PathVariable int number) {
        boolean validationResult = WeightValidator.validate(weight);

        if(!validationResult) {
            return "redirect:/storekeeper/shipment/"+number;
        }

        this.shippingService.sendShipment(number, weight);

        //TODO status paczki
        return "redirect:/login";
    }

    @RequestMapping(value = "/getShipping", method = RequestMethod.GET)
    public String getShippingNumberForm() {
        return "storekeeper/shipmentNumberForm";
    }

    @RequestMapping(value = "/getShipping", method = RequestMethod.POST)
    public String getShippingNumber(@RequestParam String number) {
        return "redirect:/storekeeper/getShipping/"+number;
    }

    @RequestMapping(value = "/getShipping/{number}", method = RequestMethod.GET)
    public String getShippingForm(@PathVariable int number, Model model) {
        Optional<Shipping> shipping = this.shippingService.getShippingByNumber(number);
        if(shipping.isPresent()) {
            model.addAttribute("shipping", shipping.get());
            return "storekeeper/getShippingForm";
        } else {
            return "redirect:/storekeeper/getShipping";
        }
    }

    @RequestMapping(value = "/getShipping/{number}", method = RequestMethod.POST)
    public String getShipping(@PathVariable int number, @RequestParam String city) {
        this.shippingService.getShipment(number, city);
        //TODO przeglądanie statusu paczki
        return "redirect:/login";
    }
}
