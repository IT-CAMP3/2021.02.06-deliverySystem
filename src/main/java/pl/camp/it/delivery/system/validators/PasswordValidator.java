package pl.camp.it.delivery.system.validators;

import pl.camp.it.delivery.system.model.view.LoginObject;

import java.util.regex.Pattern;

public class PasswordValidator {
    public static boolean validate(String password) {
        Pattern lengthPattern = Pattern.compile(".{8}.*");
        Pattern capitalPattern = Pattern.compile(".*[A-Z]{1}.*");
        Pattern characterPattern = Pattern.compile(".*[\\!\\@\\#\\$\\%\\^\\&\\*\\?\\>\\<\\;\\:\\-\\_\\=\\+\\.]{1}.*");
        Pattern digitPattern = Pattern.compile(".*[0-9].*");

        return lengthPattern.matcher(password).matches() &&
                capitalPattern.matcher(password).matches() &&
                characterPattern.matcher(password).matches() &&
                digitPattern.matcher(password).matches();
    }
}
