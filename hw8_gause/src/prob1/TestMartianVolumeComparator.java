package prob1;

import java.util.ArrayList;

public class TestMartianVolumeComparator {

    public static void main(String[] args) {
        testMartianVolumeComparator_LessThan();
        testMartianVolumeComparator_GreaterThan();
        testMartianVolumeComparator_EqualTo();
        testMartianVolumeComparator_EqualId_EqualVolume();
        testMartianVolumeComparator_EqualId_DifferentVolume();
        testMartianVolumeComparator_LessThanId_EqualVolume();
        testMartianVolumeComparator_GreaterThanId_EqualVolume();
        testMartianVolumeComparator_SortedMartians();
    }

    public static void testMartianVolumeComparator_LessThan() {
        System.out.println("\n-----testMartianVolumeComparator_LessThan");
        MartianVolumeComparator martianVolumeComparator = new MartianVolumeComparator();

        Martian m1 = new GreenMartian(1);
        Martian m2 = new GreenMartian(2);

        System.out.println("Expected: -1");
        System.out.println("  Actual: " + martianVolumeComparator.compare(m1, m2));
    }    

    public static void testMartianVolumeComparator_GreaterThan() {
        System.out.println("\n-----testMartianVolumeComparator_GreaterThan");
        MartianVolumeComparator martianVolumeComparator = new MartianVolumeComparator();

        Martian m1 = new GreenMartian(2);
        Martian m2 = new GreenMartian(1);

        System.out.println("Expected: 1");
        System.out.println("  Actual: " + martianVolumeComparator.compare(m1, m2));
    }    

    public static void testMartianVolumeComparator_EqualTo() {
        System.out.println("\n-----testMartianVolumeComparator_EqualTo");
        MartianVolumeComparator martianVolumeComparator = new MartianVolumeComparator();

        Martian m1 = new GreenMartian(1);
        Martian m2 = new GreenMartian(1);

        System.out.println("Expected: 0");
        System.out.println("  Actual: " + martianVolumeComparator.compare(m1, m2));
    }

    public static void testMartianVolumeComparator_EqualId_EqualVolume() {
        System.out.println("\n-----testMartianVolumeComparator_EqualId_EqualVolume");
        MartianVolumeComparator martianVolumeComparator = new MartianVolumeComparator();

        Martian m1 = new GreenMartian(1, 2);
        Martian m2 = new GreenMartian(1, 2);

        System.out.println("Expected: 0");
        System.out.println("  Actual: " + martianVolumeComparator.compare(m1, m2));
    }    

    public static void testMartianVolumeComparator_EqualId_DifferentVolume() {
        System.out.println("\n-----testMartianVolumeComparator_EqualId_DifferentVolume");
        MartianVolumeComparator martianVolumeComparator = new MartianVolumeComparator();

        Martian m1 = new GreenMartian(1, 2);
        Martian m2 = new GreenMartian(1, 3);

        System.out.println("Expected: -1");
        System.out.println("  Actual: " + martianVolumeComparator.compare(m1, m2));
    }    

    public static void testMartianVolumeComparator_LessThanId_EqualVolume() {
        System.out.println("\n-----testMartianVolumeComparator_LessThanId_EqualVolume");
        MartianVolumeComparator martianVolumeComparator = new MartianVolumeComparator();

        Martian m1 = new GreenMartian(1, 2);
        Martian m2 = new GreenMartian(2, 2);

        System.out.println("Expected: -1");
        System.out.println("  Actual: " + martianVolumeComparator.compare(m1, m2));
    }    

    public static void testMartianVolumeComparator_GreaterThanId_EqualVolume() {
        System.out.println("\n-----testMartianVolumeComparator_GreaterThanId_EqualVolume");
        MartianVolumeComparator martianVolumeComparator = new MartianVolumeComparator();

        Martian m1 = new GreenMartian(2, 2);
        Martian m2 = new GreenMartian(1, 2);

        System.out.println("Expected: 1");
        System.out.println("  Actual: " + martianVolumeComparator.compare(m1, m2));
    }    

    public static void testMartianVolumeComparator_SortedMartians() {
        System.out.println("\n-----testMartianVolumeComparator_SortedMartians");
        MartianVolumeComparator martianVolumeComparator = new MartianVolumeComparator();

        GreenMartian m1 = new GreenMartian(1, 3);
        RedMartian m2 = new RedMartian(4, 2, 2);
        GreenMartian m3 = new GreenMartian(3, 1);
        RedMartian m4 = new RedMartian(2, 3, 3);

        ArrayList<Martian> martiansList = new ArrayList<>();

        martiansList.add(m1);
        martiansList.add(m2);
        martiansList.add(m3);
        martiansList.add(m4);
        
        System.out.println("Before Sorting");
        System.out.println(martiansList);

        martiansList.sort(martianVolumeComparator);

        System.out.println("After Sorting");
        System.out.println(martiansList);

    }    
    
}
