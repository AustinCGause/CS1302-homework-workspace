package prob1;

public class ClassicYellowCake extends Cake {

    public ClassicYellowCake(String cakeMix) {
        super(cakeMix);
    }

    @Override
    public String getLiquid() {
        return "1 cup tap water";
    }

    @Override
    public String getOil() {
        return "1/3 cup vegetable oil";
    }

    @Override
    public String getEggs() {
        return "3 large eggs";
    }
    
}
