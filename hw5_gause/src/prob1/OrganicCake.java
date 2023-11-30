package prob1;

public class OrganicCake extends Cake {
    
    public OrganicCake(String cakeMix) {
        super(cakeMix);
    }

    @Override
    public String getLiquid() {
        return "1 1/4 cup milk";
    }
    @Override
    public String getOil() {
        return "1/2 cup canola oil";
    }

    @Override
    public String getEggs() {
        return "2 large eggs";
    }
}
