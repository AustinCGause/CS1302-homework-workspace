package prob3;

import java.util.ArrayList;

public class MartianManagerTest {
    
    public static void main(String[] args) {
        testAddMartian_Red_Success();
        testAddMartian_Green_Success();
        testAddMartian_RedGreen_Failure();
        testAddMartian_GreenRed_Failure();
        testContains_Success();
        testContains_Failure();
        testGetMartianAt_ValidIndex();
        testGetMartianAt_InvalidIndex_Low();
        testGetMartianAt_InvalidIndex_High();
        testGetMartianClosestTo_Index_LowerMatch();
        testGetMartianClosestTo_Index_HigherMatch();
        testGetMartianClosestTo_Martian_LowerMatch();
        testGetMartianWithId_Success();
        testGetMartianWithId_Failure();
        testGetSortedMartians();
        testGetTeleporterAt_ValidIndex();
        testGetTeleporterAt_InvalidIndex_Low();
        testGetTeleporterAt_InvalidIndex_High();
        testGroupSpeak();
        testGroupTeleport();
        testObliterateTeleporters_One();
        testObliterateTeleporters_Many();
        testRemoveMartianWithId_Success_Red();
        testRemoveMartianWithId_Success_Green();
        testRemoveMartianWithId_Failure();
        testToString();
        testBattle_Small();
        testBattle_Larger();
    }

    private static void testAddMartian_Red_Success() {
        System.out.println("\n-----testAddMartian_Red_Success:");

        MartianManager mm = new MartianManager();
        RedMartian rm = createRedMartian(854, 10);

        mm.addMartian(rm);

        System.out.println(mm);
    }

    private static void testAddMartian_Green_Success() {
        System.out.println("\n-----testAddMartian_Green_Success:");

        MartianManager mm = new MartianManager();
        GreenMartian gm = createGreenMartian(854);

        mm.addMartian(gm);

        System.out.println(mm);
    }

    private static void testAddMartian_RedGreen_Failure() {
        System.out.println("\n-----testAddMartian_RedGreen_Failure:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new RedMartian(875, 4),
            new GreenMartian(875),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);

        System.out.println(mm);
        System.out.println("Num teleporters=" + mm.getNumTeleporters());
    }

    private static void testAddMartian_GreenRed_Failure() {
        System.out.println("\n-----testAddMartian_GreenRed_Failure:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(875, 4),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);

        System.out.println(mm);
        System.out.println("Num teleporters=" + mm.getNumTeleporters());
    }

    private static void testContains_Success() {
        System.out.println("\n-----testContains_Success:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(892, 4),
            new GreenMartian(843),
            new RedMartian(542, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("mm contains id=892");
        System.out.println("Expected=true");
        System.out.println("  Actual=" + mm.contains(892));
    }

    private static void testContains_Failure() {
        System.out.println("\n-----testContains_Failure:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(892, 4),
            new GreenMartian(843),
            new RedMartian(542, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("mm contains id=123");
        System.out.println("Expected=false");
        System.out.println("  Actual=" + mm.contains(123));
    }

    private static void testGetMartianAt_ValidIndex() {
        System.out.println("\n-----testGetMartianAt_ValidIndex:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(892, 4),
            new GreenMartian(843),
            new RedMartian(542, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("Martian at index 1");
        System.out.println("Expected=Red Martian - id=892, vol=1, ten=4");
        System.out.println("  Actual=" + mm.getMartianAt(1));
    }

    private static void testGetMartianAt_InvalidIndex_Low() {
        System.out.println("\n-----testGetMartianAt_InvalidIndex_Low:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(892, 4),
            new GreenMartian(843),
            new RedMartian(542, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("Martian at index -1");
        System.out.println("Expected=null");
        System.out.println("  Actual=" + mm.getMartianAt(-1));
    }

    private static void testGetMartianAt_InvalidIndex_High() {
        System.out.println("\n-----testGetMartianAt_InvalidIndex_High:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(892, 4),
            new GreenMartian(843),
            new RedMartian(542, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("Martian at index 20");
        System.out.println("Expected=null");
        System.out.println("  Actual=" + mm.getMartianAt(20));
    }

    private static void testGetMartianClosestTo_Index_LowerMatch() {
        System.out.println("\n-----testGetMartianClosestTo_Index_LowerMatch:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(1),
            new RedMartian(3, 4),
            new GreenMartian(8),
            new RedMartian(13, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("Martian closest to id=4");
        System.out.println("Expected=Red Martian - id=3, vol=1, ten=4");
        System.out.println("  Actual=" + mm.getMartianClosestTo(4));
    }

    private static void testGetMartianClosestTo_Index_HigherMatch() {
        System.out.println("\n-----testGetMartianClosestTo_Index_HigherMatch:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(1),
            new RedMartian(3, 4),
            new GreenMartian(8),
            new RedMartian(13, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("Martian closest to id=6");
        System.out.println("Expected=Green Martian - id=8, vol=1");
        System.out.println("  Actual=" + mm.getMartianClosestTo(8));
    }

    private static void testGetMartianClosestTo_Martian_LowerMatch() {
        System.out.println("\n-----testGetMartianClosestTo_Martian_LowerMatch:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(1),
            new RedMartian(3, 4),
            new GreenMartian(8),
            new RedMartian(13, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);

        GreenMartian dummyMartian = new GreenMartian(6);
        
        System.out.println("Martian closest to id=6");
        System.out.println("Expected=Green Martian - id=8, vol=1");
        System.out.println("  Actual=" + mm.getMartianClosestTo(dummyMartian));
    }

    private static void testGetMartianWithId_Success() {
        System.out.println("\n-----testGetMartianWithId_Success:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(1),
            new RedMartian(3, 4),
            new GreenMartian(8),
            new RedMartian(13, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("Get Martian with id=8");
        System.out.println("Expected=Green Martian - id=8, vol=1");
        System.out.println("  Actual=" + mm.getMartianWithId(8));
    }

    private static void testGetMartianWithId_Failure() {
        System.out.println("\n-----testGetMartianWithId_Failure:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(1),
            new RedMartian(3, 4),
            new GreenMartian(8),
            new RedMartian(13, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("Get Martian with id=15");
        System.out.println("Expected=null");
        System.out.println("  Actual=" + mm.getMartianWithId(15));
    }

    private static void testGetSortedMartians() {
        System.out.println("\n-----testGetSortedMartians:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(4),
            new RedMartian(8, 4),
            new GreenMartian(1),
            new RedMartian(2, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("Before Sorting:");
        System.out.println("Expected=[Green Martian - id=4, vol=1, Red Martian - id=8, vol=1, ten=4, Green Martian - id=1, vol=1, Red Martian - id=2, vol=1, ten=2]");
        System.out.println("  Actual=" + mm.martians);

        System.out.println("\nSorting:");
        System.out.println("Expected=[Green Martian - id=1, vol=1, Red Martian - id=2, vol=1, ten=2, Green Martian - id=4, vol=1, Red Martian - id=8, vol=1, ten=4]");
        System.out.println("  Actual=" + mm.getSortedMartians());

        System.out.println("\nAfter Sorting:");
        System.out.println("Expected=[Green Martian - id=4, vol=1, Red Martian - id=8, vol=1, ten=4, Green Martian - id=1, vol=1, Red Martian - id=2, vol=1, ten=2]");
        System.out.println("  Actual=" + mm.martians);

    }

    private static void testGetTeleporterAt_ValidIndex() {
        System.out.println("\n-----testGetTeleporterAt_ValidIndex:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new GreenMartian(324),
            new RedMartian(892, 4),
            new GreenMartian(843),
            new GreenMartian(942),
            new RedMartian(542, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        mm.addMartian(martians[4]);
        mm.addMartian(martians[5]);
        
        System.out.println("Teleporter at index 2");
        System.out.println("Expected=Green Martian - id=843, vol=1");
        System.out.println("  Actual=" + mm.getTeleporterAt(2));
    }

    private static void testGetTeleporterAt_InvalidIndex_Low() {
        System.out.println("\n-----testGetTeleporterAt_InvalidIndex_Low:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new GreenMartian(324),
            new RedMartian(892, 4),
            new GreenMartian(843),
            new GreenMartian(942),
            new RedMartian(542, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        mm.addMartian(martians[4]);
        mm.addMartian(martians[5]);
        
        System.out.println("Teleporter at index -1");
        System.out.println("Expected=null");
        System.out.println("  Actual=" + mm.getTeleporterAt(-1));
    }

    private static void testGetTeleporterAt_InvalidIndex_High() {
        System.out.println("\n-----testGetTeleporterAt_InvalidIndex_High:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new GreenMartian(324),
            new RedMartian(892, 4),
            new GreenMartian(843),
            new GreenMartian(942),
            new RedMartian(542, 2),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        mm.addMartian(martians[4]);
        mm.addMartian(martians[5]);
        
        System.out.println("Teleporter at index 20");
        System.out.println("Expected=null");
        System.out.println("  Actual=" + mm.getTeleporterAt(20));
    }

    private static void testGroupSpeak() {
        System.out.println("\n-----testGroupSpeak:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(892, 4),
            new RedMartian(942, 7),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        
        System.out.println(mm.groupSpeak());
    }

    private static void testGroupTeleport() {
        System.out.println("\n-----testGroupTeleport:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new GreenMartian(526),
            new RedMartian(942, 7),
            new GreenMartian(234),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println(mm.groupTeleport("Ohio"));
    }

    private static void testObliterateTeleporters_One() {
        System.out.println("\n-----testObliterateTeleporters_One:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(892, 4),
            new RedMartian(942, 7),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        
        System.out.println("Before obliterateTeleporters: " + mm);
        mm.obliterateTeleporters();
        System.out.println("After obliterateTeleporters: " + mm);
    }

    private static void testObliterateTeleporters_Many() {
        System.out.println("\n-----testObliterateTeleporters_Many:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(892, 4),
            new GreenMartian(732),
            new RedMartian(941, 7),
            new GreenMartian(397),
            new RedMartian(856, 7),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        mm.addMartian(martians[4]);
        mm.addMartian(martians[5]);
        
        System.out.println("Before obliterateTeleporters: " + mm);
        mm.obliterateTeleporters();
        System.out.println("After obliterateTeleporters: " + mm);
    }

    private static void testRemoveMartianWithId_Success_Red() {
        System.out.println("\n-----testRemoveMartianWithId_Success_Red:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(892, 4),
            new GreenMartian(732),
            new RedMartian(941, 7),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("Red Martian with id=892");
        System.out.println("Expected=Red Martian - id=892, vol=1, ten=4");
        System.out.println("  Actual=" + mm.removeMartian(892));
    }

    private static void testRemoveMartianWithId_Success_Green() {
        System.out.println("\n-----testRemoveMartianWithId_Success_Green:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(892, 4),
            new GreenMartian(732),
            new RedMartian(941, 7),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("Green Martian with id=732");
        System.out.println("Expected=Green Martian - id=732, vol=1");
        System.out.println("  Actual=" + mm.removeMartian(732));
    }

    private static void testRemoveMartianWithId_Failure() {
        System.out.println("\n-----testRemoveMartianWithId_Failure:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(892, 4),
            new GreenMartian(732),
            new RedMartian(941, 7),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("Martian with id=999");
        System.out.println("Expected=null");
        System.out.println("  Actual=" + mm.removeMartian(999));
    }

    private static void testToString() {
        System.out.println("\n-----testToString:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875),
            new RedMartian(892, 4),
            new GreenMartian(732),
            new RedMartian(941, 7),
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);
        
        System.out.println("Expected=[Green Martian - id=875, vol=1, Red Martian - id=892, vol=1, ten=4, Green Martian - id=732, vol=1, Red Martian - id=941, vol=1, ten=7]");
        System.out.println("  Actual=" + mm);
    }

    private static void testBattle_Small() {
        System.out.println("\n-----testBattle_Small:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875, 8),           // power=8
            new RedMartian(892, 5, 4), // power=9
            new GreenMartian(732, 4),           // power=4
            new RedMartian(941, 1, 7), // power=8
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);

        ArrayList<Martian> invaders = new ArrayList<>();

        GreenMartian gmi =  new GreenMartian(25, 2);         // power=2
        RedMartian rmi = new RedMartian(843, 3, 6); // power=9

        invaders.add(gmi);
        invaders.add(rmi);
        
        System.out.println("\nBefore Battle:");
        System.out.println("KilledMartians=");
        System.out.println("      martians=" + mm);

        System.out.println("\nAfter Battle:");
        System.out.println("killedMartians=" + mm.battle(invaders));
        System.out.println("      martians=" + mm);
    }

    private static void testBattle_Larger() {
        System.out.println("\n-----testBattle_Larger:");

        MartianManager mm = new MartianManager();
        Martian[] martians = {
            new GreenMartian(875, 8),           // power=8
            new RedMartian(892, 5, 4), // power=9
            new GreenMartian(732, 4),           // power=4
            new RedMartian(941, 1, 7), // power=8
            new GreenMartian(732, 7),           // power=7
        };

        mm.addMartian(martians[0]);
        mm.addMartian(martians[1]);
        mm.addMartian(martians[2]);
        mm.addMartian(martians[3]);

        ArrayList<Martian> invaders = new ArrayList<>();

        GreenMartian gmi =  new GreenMartian(25, 6);         // power=6
        RedMartian rmi = new RedMartian(843, 3, 6); // power=9
        GreenMartian gmi2 =  new GreenMartian(25, 2);         // power=2

        invaders.add(gmi);
        invaders.add(rmi);
        invaders.add(gmi2);
        
        System.out.println("\nBefore Battle:");
        System.out.println("KilledMartians=");
        System.out.println("      martians=" + mm);

        System.out.println("\nAfter Battle:");
        System.out.println("killedMartians=" + mm.battle(invaders));
        System.out.println("      martians=" + mm);
    }

    // Helper Methods
    private static GreenMartian createGreenMartian(int id) {
        return new GreenMartian(id);
    }

    private static RedMartian createRedMartian(int id, int tenacity) {
        return new RedMartian(id, tenacity);
    }

}
