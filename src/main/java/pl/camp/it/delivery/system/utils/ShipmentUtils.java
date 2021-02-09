package pl.camp.it.delivery.system.utils;

import java.util.Random;

public class ShipmentUtils {
    public static int generateShipmentNumber() {
        return new Random().nextInt(899999999) + 100000000;
    }
}
