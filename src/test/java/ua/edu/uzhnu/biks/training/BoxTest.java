package ua.edu.uzhnu.biks.training;

import org.junit.Assert;
import org.junit.Test;
import ua.edu.uzhnu.biks.training.lecture3.oop.Cat;
import ua.edu.uzhnu.biks.training.lecture5.generics.Box;

/**
 * Created by Actine on 16.03.2017.
 */
public class BoxTest {

    @Test
    public void test_BoxHoldsObject() {
        Box<Cat> box = new Box<>();
        Cat cat = new Cat(12, 23);
        box.setValue(cat);

//        Assert.assertEquals(cat, box.getValue());
        Assert.assertEquals(cat.getWeight(), box.getValue().getWeight(), 0.0001);

        Box<String> box2 = new Box<>();
        box2.setValue("sdfsd");
        box2.getValue();
    }

}
