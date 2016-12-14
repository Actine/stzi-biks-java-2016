package lecture3.oop;

import java.util.Random;

/**
 * Кіт є підтипом котячих і наслідує всі властивості котячих, включаючи те, що вони видають звук.
 * Крім цього, у кота можна вичислити об'єм (інтерфейс реалізований тут, а не у Felidae, просто для демонстрації,
 * що так можна.  Зрештою, може, об'єм є не у всіх котячих?)
 */
public class Cat extends Felidae implements HasVolume {

    private String breed;
    public static boolean isCute;

    // Статичний блок - викликається один раз при першому звертанні до класу.
    // Може ініціалізувати статичні поля класу
    static {
        int a = 1;
        int b = 5;
        if (a > b) {
            isCute = false;
        } else {
            isCute = true;
        }
    }

    // Статичні фінальні поля зазвичай використовуються як КОНСТАНТИ
    public static final String BREED_STRAY = "Stray";
    public static final String BREED_SIAMESE = "Siamese";
    public static final String BREED_EGYPTIAN = "Egyptian";

    // Фабричний метод, який створює рендомного кота.
    // Це ж саме можна було би написати і у конструкторі, але цій логіці там не місце.
    // Конструктор повинен залишатись універсальним і лаконічним, і тільки забезпечувати те, щоби об’єкт не можна було
    // створити без заданого початкового стану.
    public static Cat makeRandomCat() {
        Random random = new Random();
        String breed;
        switch (random.nextInt(3)) {
            case 0:
                breed = BREED_SIAMESE;
                break;
            case 1:
                breed = BREED_EGYPTIAN;
                break;
            default:
                breed = BREED_STRAY;
        }
        return new Cat(
                random.nextInt(24) + 1,
                random.nextDouble() * 3 + 2,
                breed
        );
    }

    public Cat(int age, double weight, String breed) {
        super(age, weight);
        this.breed = breed;
    }

    public Cat(int age, double weight) {
        // Дворовий кіт
        this(age, weight, BREED_STRAY);
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String getSound() {
        return "Pur-r-r-r";
    }

    public String getSound(boolean loud) {
        if (loud) {
            return "MRRRRREOW";
        } else {
            return getSound();
        }
    }

    @Override
    public String toString() {
        // Ми зробили поля `age` i `weight` приватними, щоби підкласи не могли їх міняти протягом життя об’єкта
        // - але у нас все ще є геттери
        return "Cat{" +
                "age=" + getAge() + ", " +
                "weight=" + getWeight() + ", " +
                "breed='" + breed + '\'' +
                '}';
    }

    @Override
    public int getVolume() {
        return (int) (30 * 20 * 10 * getWeight() * Math.PI);
    }

    public static boolean isCute() {
        // Просто демонстрація того, що у статичних методах спокійно можна створювати нові об’єкти.
        // Єдине, чого тут немає - «нинішнього» об’єкту (this), оскільки статичні методи викликаются у самого КЛАСУ.

        // getBreed();                // not ok - getBreed() у кого?
        // new Cat(1, 2).getBreed();  // ok

        return isCute;
    }

}
