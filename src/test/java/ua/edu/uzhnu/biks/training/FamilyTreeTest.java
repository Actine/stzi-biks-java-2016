package ua.edu.uzhnu.biks.training;

import org.junit.Test;
import ua.edu.uzhnu.biks.training.task5.familytree.Female;
import ua.edu.uzhnu.biks.training.task5.familytree.Male;
import ua.edu.uzhnu.biks.training.task5.familytree.Person;

/**
 * Created by Actine on 16.03.2017.
 */
public class FamilyTreeTest {

    @Test
    public void test_DefaultPeople() {
        Male ivan = new Male("Іван", Male.DEFAULT, Female.DEFAULT);
        Female marina = new Female("Марина", Male.DEFAULT, Female.DEFAULT);
        Female katia = new Female("Катя", ivan, marina);

        katia.getFather().getFather().getFather().getMother().getName();

        Female sameObject = getSameObject(katia);
    }

    private <T extends Person> T getSameObject(T value) {
        if (value.getName() != null) {
            return value;
        } else {
            return null;
        }
    }

}
