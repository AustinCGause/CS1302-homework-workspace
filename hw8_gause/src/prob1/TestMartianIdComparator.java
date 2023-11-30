package prob1;

import java.util.ArrayList;

public class TestMartianIdComparator {

    public static void main(String[] args) {
        testMartianIdComparator_LessThan();
        testMartianIdComparator_GreaterThan();
        testMartianIdComparator_EqualTo();
        testMartianIdComparator_EqualId_EqualVolume();
        testMartianIdComparator_EqualId_DifferentVolume();
        testMartianIdComparator_LessThanId_EqualVolume();
        testMartianIdComparator_GreaterThanId_EqualVolume();
        testMartianIdComparator_SortedMartians();
    }

    public static void testMartianIdComparator_LessThan() {
        System.out.println("\n-----testMartianIdComparator_LessThan");
        MartianIdComparator martianIdComparator = new MartianIdComparator();

        Martian m1 = new GreenMartian(1);
        Martian m2 = new GreenMartian(2);

        System.out.println("Expected: -1");
        System.out.println("  Actual: " + martianIdComparator.compare(m1, m2));
    }    

    public static void testMartianIdComparator_GreaterThan() {
        System.out.println("\n-----testMartianIdComparator_GreaterThan");
        MartianIdComparator martianIdComparator = new MartianIdComparator();

        Martian m1 = new GreenMartian(2);
        Martian m2 = new GreenMartian(1);

        System.out.println("Expected: 1");
        System.out.println("  Actual: " + martianIdComparator.compare(m1, m2));
    }    

    public static void testMartianIdComparator_EqualTo() {
        System.out.println("\n-----testMartianIdComparator_EqualTo");
        MartianIdComparator martianIdComparator = new MartianIdComparator();

        Martian m1 = new GreenMartian(1);
        Martian m2 = new GreenMartian(1);

        System.out.println("Expected: 0");
        System.out.println("  Actual: " + martianIdComparator.compare(m1, m2));
    }

    public static void testMartianIdComparator_EqualId_EqualVolume() {
        System.out.println("\n-----testMartianIdComparator_EqualId_EqualVolume");
        MartianIdComparator martianIdComparator = new MartianIdComparator();

        Martian m1 = new GreenMartian(1, 2);
        Martian m2 = new GreenMartian(1, 2);

        System.out.println("Expected: 0");
        System.out.println("  Actual: " + martianIdComparator.compare(m1, m2));
    }    

    public static void testMartianIdComparator_EqualId_DifferentVolume() {
        System.out.println("\n-----testMartianIdComparator_EqualId_DifferentVolume");
        MartianIdComparator martianIdComparator = new MartianIdComparator();

        Martian m1 = new GreenMartian(1, 2);
        Martian m2 = new GreenMartian(1, 3);

        System.out.println("Expected: 0");
        System.out.println("  Actual: " + martianIdComparator.compare(m1, m2));
    }    

    public static void testMartianIdComparator_LessThanId_EqualVolume() {
        System.out.println("\n-----testMartianIdComparator_LessThanId_EqualVolume");
        MartianIdComparator martianIdComparator = new MartianIdComparator();

        Martian m1 = new GreenMartian(1, 2);
        Martian m2 = new GreenMartian(2, 2);

        System.out.println("Expected: -1");
        System.out.println("  Actual: " + martianIdComparator.compare(m1, m2));
    }    

    public static void testMartianIdComparator_GreaterThanId_EqualVolume() {
        System.out.println("\n-----testMartianIdComparator_GreaterThanId_EqualVolume");
        MartianIdComparator martianIdComparator = new MartianIdComparator();

        Martian m1 = new GreenMartian(2, 2);
        Martian m2 = new GreenMartian(1, 2);

        System.out.println("Expected: 1");
        System.out.println("  Actual: " + martianIdComparator.compare(m1, m2));
    }    

    public static void testMartianIdComparator_SortedMartians() {
        System.out.println("\n-----testMartianIdComparator_SortedMartians");
        MartianIdComparator martianIdComparator = new MartianIdComparator();

        GreenMartian m1 = new GreenMartian(1);
        RedMartian m2 = new RedMartian(4, 1);
        GreenMartian m3 = new GreenMartian(3);
        RedMartian m4 = new RedMartian(2, 1);

        ArrayList<Martian> martiansList = new ArrayList<>();

        martiansList.add(m1);
        martiansList.add(m2);
        martiansList.add(m3);
        martiansList.add(m4);
        
        System.out.println("Before Sorting");
        System.out.println(martiansList);

        martiansList.sort(martianIdComparator);

        System.out.println("After Sorting");
        System.out.println(martiansList);

    }    
    
}
