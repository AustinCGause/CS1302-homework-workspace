package prob1;

import java.util.Comparator;
import java.util.Map;

public class CodeComparator2 implements Comparator<Product> {

    Map<String, Integer> codeValuesMap = Map.of("QZ",1, "DC",2, "ML",3);
    
    @Override
    public int compare(Product p1, Product p2) {
        
        // normally would use a helper method for code parsing, 
        // but for simplicity I avoided it

        // parse codes and remove 't' from the end if present and extract prefix & suffix
        String codeP1 = p1.getCode();
        boolean tPresentCodeP1 = codeP1.endsWith("t");
        codeP1 = (tPresentCodeP1) ? codeP1.substring(0, codeP1.length() - 1) : codeP1;
        String prefixP1 = codeP1.substring(0, 2);
        int suffixP1 = Integer.parseInt(codeP1.substring(3));

        String codeP2 = p2.getCode();
        boolean tPresentCodeP2 = codeP2.endsWith("t");
        codeP2 = (tPresentCodeP2) ? codeP2.substring(0, codeP2.length() - 1) : codeP2;
        String prefixP2 = codeP2.substring(0, 2);
        int suffixP2 = Integer.parseInt(codeP2.substring(3));

        // uses a map to compare associated prefix values only if prefixes aren't equal
        if (prefixP1.equals(prefixP2)) { 
            if (tPresentCodeP1 || tPresentCodeP2) {
                return (tPresentCodeP1) ? -1 : 1;
            } else {
                return Integer.compare(suffixP1, suffixP2); 
            }
        }
        else { 
            return Integer.compare(codeValuesMap.get(prefixP1), codeValuesMap.get(prefixP2)); 
        }

        // // compare by prefix order. If prefixes are same, compare suffixes.
        // if (prefixP1.equals(prefixP2)) { return suffixP1 - suffixP2; }
        // else if (prefixP1.equals("QZ")) { return -1; }
        // else if (prefixP1.equals("DC")) {

        //     if (prefixP2.equals("QZ")) { return 1; }
        //     else { return -1; }

        // }
        // else { return 1; }
        
    }

}
