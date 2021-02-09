package pl.camp.it.delivery.system.validators;

import org.junit.Assert;
import org.junit.Test;
import pl.camp.it.delivery.system.model.view.LoginObject;

public class LoginValidatorTest {

    @Test
    public void tooShortPassValidateTest() {
        String password = "D?5sdf";

        boolean result = PasswordValidator.validate(password);

        Assert.assertFalse(result);
    }

    @Test
    public void passWithoutCapitalTest() {
        String password = "df#3asdfre";

        boolean result = PasswordValidator.validate(password);

        Assert.assertFalse(result);
    }

    @Test
    public void passWithoutDigitTest() {
        String password = "df#Gasdfre";

        boolean result = PasswordValidator.validate(password);

        Assert.assertFalse(result);
    }

    @Test
    public void passWithoutCharacterTest() {
        String password = "df5Gasdfre";

        boolean result = PasswordValidator.validate(password);

        Assert.assertFalse(result);
    }

    @Test
    public void correctPassTest() {
        String password = "df5Ga?dfre";

        boolean result = PasswordValidator.validate(password);

        Assert.assertTrue(result);
    }
}
