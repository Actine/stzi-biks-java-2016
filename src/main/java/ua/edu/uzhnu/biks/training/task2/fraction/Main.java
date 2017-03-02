package ua.edu.uzhnu.biks.training.task2.fraction;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = Fraction.valueOf("8/12");
        System.out.println(f1);              // 8/12
        System.out.println(f1.toDouble());   // 0.6666667
        System.out.println(f1.isProper());   // true
        System.out.println(f1.inverse());    // 12/8
        System.out.println(f1.simplify());   // 2/3

        Fraction f2 = Fraction.fromDouble(2.5);
        System.out.println(Fraction.add(f1, f2));         // 19/6
        System.out.println(Fraction.subtract(f1, f2));    // -11/6
        System.out.println(Fraction.multiply(f1, f2));    // 5/3
        System.out.println(Fraction.divide(f1, f2));      // 4/15
    }
}