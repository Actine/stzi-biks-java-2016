package lecture3.oop;

import java.util.Random;

/**
 * Created by Actine on 24.11.2016.
 */
public class Main {

    public static void main(String[] args) {

        // Об'єкт, який генерує псевдорандомні значення
        Random random = new Random();

        // Робимо дві змінні під кошачих.
        // Насправді це будуть тигр і кіт, але Java дивиться на ці змінні як на будь-що кошаче,
        // і тому у змінних `a` i `b` викликати можна тільки те, що задане класом Felidae
        // ПРИ ЦЬОМУ, у кота і у тигра воно викличеться ПО-СВОЄМУ

        Felidae a = new Tiger(12, 100);
        System.out.println(a/*.toString()*/);
        System.out.println(a.getSound());
        a.eat(2.5);
        System.out.println(a);

        Felidae b = new Cat(30, 6, Cat.BREED_SIAMESE);
        System.out.println(b);
        System.out.println(b.getSound());
        b.eat(0.5);
        System.out.println(b);

        System.out.println(a instanceof Tiger);      // true
        System.out.println(a instanceof Cat);        // false
        System.out.println(a instanceof Felidae);    // true
        System.out.println(a instanceof Object);     // true
        System.out.println(a instanceof MakesSound); // true
        System.out.println(a instanceof HasVolume);  // true

        System.out.println(b instanceof Tiger);      // false
        System.out.println(b instanceof Cat);        // true
        System.out.println(b instanceof Felidae);    // true
        System.out.println(b instanceof Object);     // true
        System.out.println(b instanceof MakesSound); // true
        System.out.println(b instanceof HasVolume);  // true

        // Створення змінної із типом-узагальненням часто треба тоді, коли
        // а) наперед невідомо, який підтип буде занесений у цю змінну, або
        // б) якщо немає значення, об'єкт якого підтипу там буде - важливо тільки, щоби це був об'єкт даного супертипу

        // Тут, наприклад, створюємо змінну для будь-чого кошачого, але не знаємо наперед, чи це кіт, чи тигр
        Felidae c;
        if (random.nextBoolean()) {
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

            // викликаємо перегрузки метода getSound() із різними наборами параметрів
            System.out.println("Calm cat says " + ((Cat) c).getSound());
            System.out.println("Angry cat says " + ((Cat) c).getSound(true));
        } else {
            System.out.println("Not a cat");
        }

        // Масив усього, що має об'єм. Тут докупи будуть коти, тигри, коробки
        HasVolume[] items = new HasVolume[31];
        // 20 котів
        for (int i = 0; i < 20; i++) {
            items[i] = new Cat(random.nextInt(36), 2 + random.nextDouble() * 4);
        }
        // 10 коробок
        for (int i = 20; i < 30; i++) {
            items[i] = new Box(
                    1 + random.nextInt(60),
                    1 + random.nextInt(60),
                    1 + random.nextInt(60)
            );
        }
        // і один тигр
        items[30] = new Tiger(24, 80, true);

        // Тепер можемо обчислити сумарний об'єм, додавши об'єми усіх цих об'єктів із одного масиву.
        // Нас при цьому не цікавить, що це - тигр, кіт чи коробка - головне, що воно має об'єм
        int volume = 0;
        for (HasVolume item : items) {
            System.out.println("Volume of " + item + " = " + item.getVolume());
            volume += item.getVolume();
        }
        System.out.println("Total volume: " + volume);

        // Аналогічно можна зробити масив об'єктів, які видають звук і заважають спати
        // - навіть якщо це об'єкти із абсолютно різних ієрархій типів, їх усіх об'єднує один тип-інтерфейс
        MakesSound[] nuisances = new MakesSound[]{
                new Computer(),
                new Cat(12, 3, Cat.BREED_EGYPTIAN),
                new Box(10, 10, 10),         // падаюча коробка, яку чіпляє кіт
                new Tiger(12, 100, false)    // безсмугастий тигр, який гарчить у зоопарку напроти
        };
        for (MakesSound nuisance : nuisances) {
            System.out.println(nuisance.getSound());
        }

        System.out.println(Cat.isCute);
        Cat[] cats = new Cat[10];
        for (int i = 0; i < 10; i++) {
            cats[i] = Cat.makeRandomCat();
        }
        cats[0].isCute = false;

        for (Cat cat : cats) {
            System.out.println(cat.isCute);
        }

        System.out.println("Cats are cute? - " + Cat.isCute());

        // Ці два статичні виклики РІВНОЗНАЧНІ і викликаються на класі.
        // Повернуть не чи конкретно цей кіт милий, а чи саме поняття «кіт» миле.
        cats[0].isCute();
        Cat.isCute();

        // А цей виклик - не статичний - поверне вік конкретно цього кота
        cats[0].getAge();
    }

}
