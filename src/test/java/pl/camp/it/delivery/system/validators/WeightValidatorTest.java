package pl.camp.it.delivery.system.validators;

import org.junit.Assert;
import org.junit.Test;

public class WeightValidatorTest {

    @Test
    public void correctWeightWithDotTest() {
        String weight = "0.45";

        boolean validationResult = WeightValidator.validate(weight);

        Assert.assertTrue(validationResult);
    }

    @Test
    public void correctWeightWithCommaTest() {
        String weight = "0,45";

        boolean validationResult = WeightValidator.validate(weight);

        Assert.assertTrue(validationResult);
    }

    @Test
    public void integerWeightTest() {
        String weight = "45";

        boolean validationResult = WeightValidator.validate(weight);

        Assert.assertFalse(validationResult);
    }

    @Test
    public void notDigitWeightTest() {
        String weight = "0,45A";

        boolean validationResult = WeightValidator.validate(weight);

        Assert.assertFalse(validationResult);
    }
}
