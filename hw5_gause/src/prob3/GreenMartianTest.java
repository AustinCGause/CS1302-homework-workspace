package prob3;

public class GreenMartianTest {
    
    public static void main(String[] args) {
        testSpeakAndTeleportAndToString();
        testEquals_Success();
        testEquals_Fail();
        testEquals_RedAndGreen_Success();
        testCompareTo_RedAndGreenPositive();
    }

    private static void testSpeakAndTeleportAndToString() {
        System.out.println("\n-----testSpeakAndTeleportAndToString:");
        
        GreenMartian gm = new GreenMartian(985);

        System.out.println("" + gm.speak() + "\n" + gm.toString());
    }
    
    private static void testEquals_Success() {
        System.out.println("\n-----testEquals_Success:");

        GreenMartian gm1 = new GreenMartian(952, 11);
        GreenMartian gm2 = new GreenMartian(952);

        System.out.println(gm1.equals(gm2));
    }
    
    private static void testEquals_Fail() {
        System.out.println("\n-----testEquals_Fail:");
        
        GreenMartian gm1 = new GreenMartian(952, 11);
        GreenMartian gm2 = new GreenMartian(736);

        System.out.println(gm1.equals(gm2));
    }
    
    private static void testEquals_RedAndGreen_Success() {
        System.out.println("\n-----testEquals_RedAndGreen_Success:");
        
        RedMartian rm = new RedMartian(952, 11, 4);
        GreenMartian gm = new GreenMartian(952, 11);

        System.out.println(rm.equals(gm));
    }
    
    private static void testCompareTo_RedAndGreenPositive() {
        System.out.println("\n-----testRedTo_GreenAndGreenPositive:");

        RedMartian rm = new RedMartian(985, 11, 4);
        GreenMartian gm = new GreenMartian(215, 11);

        System.out.println(rm.compareTo(gm));
    }
    
}
