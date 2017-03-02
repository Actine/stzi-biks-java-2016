package ua.edu.uzhnu.biks.training;

import org.junit.Assert;
import org.junit.Test;
import ua.edu.uzhnu.biks.training.task2.fraction.Fraction;

/**
 * Created by Actine on 02.03.2017.
 */
public class FractionTest {

    @Test
    public void test_SanityTest_JUnitWorks() {
        Assert.assertEquals(2, 1 + 1);
    }

    @Test
    public void test_CreateFractionWithNegativeDenominator_MinusAppliesToNumerator() {
        Fraction f1 = new Fraction(2, -5);
        Assert.assertEquals(-2, f1.getNumerator());
        Assert.assertEquals(5, f1.getDenominator());

        Fraction f2 = new Fraction(-5, -8);
        Assert.assertEquals(5, f2.getNumerator());
        Assert.assertEquals(8, f2.getDenominator());
    }

}
