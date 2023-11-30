package prob1;

public class BasketballPlayer {

        /*
         * Represents a baskeball player
         */

        int freeThrowsAttempted;
        int freeThrowsMade;
        String name;
        int threePointersAttempted;
        int threePointersMade;
        int twoPointersAttempted;
        int twoPointersMade;

        public BasketballPlayer(String name) {
            this.name = name;
            this.freeThrowsAttempted = 0;
        }

        public double getFreeThrowPercent() {
            if (freeThrowsAttempted == 0) {
                return 0.0;
            }
            else {
                return ((double)freeThrowsMade / freeThrowsAttempted) * 100.0;
            }
        }
        
        public int getFreeThrowsAttempted() {
            return freeThrowsAttempted;
        }
        
        public int getFreeThrowsMade() {
            return freeThrowsMade;
        }

        public String getName() {
            return name;
        }

        public double getThreePointerPercent() {
            if (threePointersAttempted == 0) {
                return 0.0;
            }
            else {
                return ((double)threePointersMade / threePointersAttempted) * 100.0;
            }
        }

        public int getThreePointersAttempted() {
            return threePointersAttempted;
        }

        public int getThreePointersMade() {
            return threePointersMade;
        }

        public int getTotalPoints() {
            return (freeThrowsMade * 1) + (twoPointersMade * 2) + (threePointersMade * 3);
        }

        public double getTwoPointerPercent() {
            if (twoPointersAttempted == 0) {
                return 0.0;
            }
            else {
                return ((double)twoPointersMade / twoPointersAttempted) * 100.0;
            }
        }

        public int getTwoPointersAttempted() {
            return twoPointersAttempted;
        }

        public int getTwoPointersMade() {
            return twoPointersMade;
        }

        public void shootFreeThrow(boolean isMade) {
            freeThrowsAttempted++;
            if (isMade) {
                freeThrowsMade++;
            }
        }

        public void shootThreePointer(boolean isMade) {
            threePointersAttempted++;
            if (isMade) {
                threePointersMade++;
            }
        }

        public void shootTwoPointer(boolean isMade) {
            twoPointersAttempted++;
            if (isMade) {
                twoPointersMade++;
            }
        }

        @Override
        public String toString() {
            return 
            "Player:" + name + ", points:" + getTotalPoints() +
            "\n   Free Throws: made:" + getFreeThrowsMade() + ", attempted:" + getFreeThrowsAttempted() + ", percent:" + String.format("%.1f", getFreeThrowPercent()) +
            "\n    2 Pointers: made:" + getTwoPointersMade() + ", attempted:" + getTwoPointersAttempted() + ", percent:" + String.format("%.1f", getTwoPointerPercent()) +
            "\nThree Pointers: made:" + getThreePointersMade() + ", attempted:" + getThreePointersAttempted() + ", percent:" + String.format("%.1f", getThreePointerPercent());
        }

        public static void main(String[] args) {

            BasketballPlayer jordan = new BasketballPlayer("Jordan");

            System.out.println(jordan);

            System.out.println("\nInformal Tests:");
            System.out.println(jordan.getFreeThrowsAttempted());
            System.out.println(jordan.getFreeThrowPercent());
            
        }

}
