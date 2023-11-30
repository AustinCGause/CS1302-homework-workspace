package prob1;

import java.util.Comparator;

public class MartianIdComparator implements Comparator<Martian> {
    
    @Override
    public int compare(Martian m1, Martian m2) {
        
        return Integer.compare(m1.getId(), m2.getId());
        
    }

}
