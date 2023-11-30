package prob1;

public class RedMartianTest {
    
    public static void main(String[] args) {
        testSpeakAndToString();
        testEquals_Success();
        testEquals_Fail();
        testCompareTo_Negative();
        testCompareTo_Positive();
        testCompareTo_Zero();
    }

    private static void testSpeakAndToString() {
        System.out.println("\n-----testSpeakAndToString:");

        RedMartian rm = new RedMartian(859, 9, 3);

        System.out.println("" + rm.speak() + "\n" + rm.toString());
    }

    private static void testEquals_Success() {
        System.out.println("\n-----testEquals_Success:");

        RedMartian rm1 = new RedMartian(952, 11, 8);
        RedMartian rm2 = new RedMartian(952, 4);

        System.out.println(rm1.equals(rm2));
    }

    private static void testEquals_Fail() {
        System.out.println("\n-----testEquals_Fail:");

        RedMartian rm1 = new RedMartian(952, 11, 8);
        RedMartian rm2 = new RedMartian(736, 4);

        System.out.println(rm1.equals(rm2));
    }

    private static void testCompareTo_Negative() {
        System.out.println("\n-----testCompareTo_Negative:");

        RedMartian rm1 = new RedMartian(428, 11, 8);
        RedMartian rm2 = new RedMartian(736, 4);

        System.out.println(rm1.compareTo(rm2));
    }

    private static void testCompareTo_Positive() {
        System.out.println("\n-----testCompareTo_Positive:");

        RedMartian rm1 = new RedMartian(849, 11, 8);
        RedMartian rm2 = new RedMartian(736, 4);

        System.out.println(rm1.compareTo(rm2));
    }

    private static void testCompareTo_Zero() {
        System.out.println("\n-----testCompareTo_Zero:");

        RedMartian rm1 = new RedMartian(849, 11, 8);
        RedMartian rm2 = new RedMartian(849, 4);

        System.out.println(rm1.compareTo(rm2));
    }

}
