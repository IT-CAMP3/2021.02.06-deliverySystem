package pl.camp.it.delivery.system.validators;

import java.util.regex.Pattern;

public class WeightValidator {
    public static boolean validate(String weight) {
        Pattern pattern = Pattern.compile("[0-9]*[\\.\\,]{1}[0-9]*");
        return pattern.matcher(weight).matches();
    }
}
