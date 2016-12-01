package lecture1.oopintro;

import java.util.Arrays;

class Dekanat {

    public Student getLeadOfSixthGroup() {
        Student s1 = new Student();
        s1.name = "Lyubomir";
        s1.lastName = "Botsenuk";
        s1.studentId = 11616142;
        s1.university = "UzhNU";
        return s1;
    }

}

class Student {
    String name;
    String lastName;
    int studentId;
    String university;
    Grade[] grades;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId=" + studentId +
                ", university='" + university + '\'' +
                ", grades=" + Arrays.toString(grades) +
                '}';
    }

    String getFullName() {
        return name + " " + lastName;
    }

    double getAverageGrade() {
        double s = 0;
        for (int i = 0; i < grades.length; i++) {
            s += grades[i].grade;
        }
        return s / grades.length;
    }
}

class Grade {
    String subject;
    int grade;

    @Override
    public String toString() {
        return "Grade{" +
                "subject='" + subject + '\'' +
                ", grade=" + grade +
                '}';
    }
}

public class Main {
    public static void change(Student s, int a) {
        a = a + 5;
        s.name = "Petya";
    }

    public static void main(String[] args) {
        Student s1 = new Dekanat().getLeadOfSixthGroup();
        System.out.println(s1);

        s1.name = "Vasyok";
        s1.studentId = -1;

        System.out.println(s1);

//        Kassa k = new Kassa();
//        k.buyDollars(12);

        /*
        Student s2 = new Student();
        s2.name = "Vitaliy";
        s2.lastName = "Burak";
        s2.university = "UzhNU";

        /*
        s1.grades = new Grade[2];
        s1.grades[0] = new Grade();
        s1.grades[0].subject = "Math";
        s1.grades[0].grade = 90;
        s1.grades[1] = new Grade();
        s1.grades[1].subject = "Physics";
        s1.grades[1].grade = 95;

        System.out.println(s1.getFullName());
        System.out.println(s2.getFullName());
        System.out.println(s1.grades[0].subject + ": " + s1.grades[0].grade);
        System.out.println(s1.getAverageGrade());

        System.out.println(s1);

        int a = 5;
        int b = a;
        a = 10;
        System.out.println(a);
        System.out.println(b);

        Student s3 = s1;
//        s1.name = "Vasya";
        System.out.println(s1);
        System.out.println(s3);

        int x = 10;
        change(s1, x);
        System.out.println(s1);
        System.out.println(x);

        // int -2^31.. 2^31 - 1, long -2^63...2^63 - 1, byte, short;
        // float - 32b, double - 64b;
        // boolean
        // char

        String asd;
        System.out.println();
*/
    }

}
