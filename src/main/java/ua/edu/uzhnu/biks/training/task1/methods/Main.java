package ua.edu.uzhnu.biks.training.task1.methods;

public class Main {

    public static double roundLavishly(double number, double threshold) {
        if (number < 0) {
            return (int) (number % 1 > -threshold ? number : number - 1);
        } else {
            return (int) (number % 1 < threshold ? number : number + 1);
        }
    }

    public static int getUnique(int a, int b, int c) {
        // XOR двох однакових чисел дорівнює 0. XOR числа із нулем дорівнює числу.
        // Операція комутативна і асоціативна, тому порядок чисел не має значення.
        return a ^ b ^ c;
    }

    public static boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecursively(String word, int start) {
        int length = word.length();
        if (start > length / 2) {
            // Дійшли до середини слова - можна виходити із рекурсії
            return true;
        } else {
            return word.charAt(start) == word.charAt(length - start - 1) && isPalindromeRecursively(word, start + 1);
        }
    }

    public static boolean isModel(int breasts, int waist, int hips) {
        return breasts >= 88 && breasts <= 92
                && waist >= 58 && waist <= 62
                && hips >= 88 && hips <= 92;
    }

    public static boolean isRight(boolean beautiful,
                                  boolean smart,
                                  boolean joyful,
                                  boolean ideal) {
        return (beautiful && smart && joyful) == ideal;
    }

    public static boolean isSuitableHusband(boolean isCute,
                                            String carClass,
                                            int apartmentArea,
                                            int annualSalary) {
        return isCute && "Premium".equals(carClass) && apartmentArea >= 100 && annualSalary >= 800000;
    }

    public static void main(String[] args) {
        System.out.println("-- 1 --");
        System.out.println(roundLavishly(1.2, 0.3)); // 1.0
        System.out.println(roundLavishly(1.3, 0.2)); // 2.0

        System.out.println("-- 2 --");
        System.out.println(getUnique(1, 2, 2));   // 1
        System.out.println(getUnique(10, 2, 10)); // 2
        System.out.println(getUnique(15, 15, 8)); // 8

        System.out.println("-- 3 --");
        System.out.println(isPalindrome("kayak"));    // true
        System.out.println(isPalindrome("caddilac")); // false

        System.out.println("-- 4 --");
        System.out.println(isPalindromeRecursively("racecar", 0));  // true
        System.out.println(isPalindromeRecursively("autocar", 0));  // false

        System.out.println("-- 5 --");
        System.out.println(isModel(91, 59, 92));    // true
        System.out.println(isModel(87, 60, 90));    // false

        System.out.println("-- 6 --");
        System.out.println(isRight(true, true, true, true));     // true
        System.out.println(isRight(true, true, false, true));    // false
        System.out.println(isRight(false, true, false, false));  // true
        System.out.println(isRight(false, false, false, false)); // true
        System.out.println(isRight(false, false, false, true));  // false

        System.out.println("-- 7 --");
        System.out.println(isSuitableHusband(true, "Premium", 120, 950000));  // true
        System.out.println(isSuitableHusband(false, "Premium", 110, 800000)); // false
        System.out.println(isSuitableHusband(true, "Budget", 80, 120000));    // false
    }
}
