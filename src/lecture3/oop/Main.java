package lecture3.oop;

import java.util.Random;

/**
 * Created by Actine on 24.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        // Робимо дві змінні під кошачих.
        // Насправді це будуть тигр і кіт, але Java дивиться на ці змінні як на будь-що кошаче,
        // і тому у змінних `a` i `b` викликати можна тільки те, що задане класом Felidae
        // ПРИ ЦЬОМУ, у кота і у тигра воно викличеться ПО-СВОЄМУ

        Felidae a = new Tiger(12, 100);
        System.out.println(a/*.toString()*/);
        System.out.println(a.getSound());
        a.eat(2.5);
        System.out.println(a);

        Felidae b = new Cat(30, 6, "Siamese");
        System.out.println(b);
        System.out.println(b.getSound());
        b.eat(0.5);
        System.out.println(b);

        System.out.println(a instanceof Tiger);      // true
        System.out.println(a instanceof Cat);        // false
        System.out.println(a instanceof Felidae);    // true
        System.out.println(a instanceof Object);     // true

        System.out.println(b instanceof Tiger);      // false
        System.out.println(b instanceof Cat);        // true
        System.out.println(b instanceof Felidae);    // true
        System.out.println(b instanceof Object);     // true

        // Створення змінної із типом-узагальненням часто треба тоді, коли
        // а) наперед невідомо, який підтип буде занесений у цю змінну, або
        // б) якщо немає значення, об'єкт якого підтипу там буде - важливо тільки, щоби це був об'єкт даного супертипу

        // Тут, наприклад, створюємо змінну для будь-чого кошачого, але не знаємо наперед, чи це кіт, чи тигр
        Felidae c;
        if (new Random().nextBoolean()) {
            // Якщо випав орел - буде кіт
            c = new Cat(3, 6);
        } else {
            // Якщо решка - тигр
            c = new Tiger(3, 160, false);
        }

        c.eat(0.5);
        if (c instanceof Cat) {
            // Якщо потрібно, можна спробувати привести (cast) тип змінної до підтипу (downcast)
            // Якщо виявиться, що у змінній `c` не кіт, наступний виклик видав би помилку.
            // Тому рекомендується такі виклики писати усередині перевірки `if (x instanceof Type)`
            System.out.println("Cat of " + ((Cat) c).getBreed() + " breed");
        } else {
            System.out.println("Not a cat");
        }
    }

}
