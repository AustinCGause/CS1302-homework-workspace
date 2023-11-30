package prob1;

public class HighAltitudeClassicYellowCake extends ClassicYellowCake {
    
    public HighAltitudeClassicYellowCake(String cakeMix) {
        super(cakeMix);
    }

    @Override
    public String getCakeMix() {
        return super.getCakeMix() + " + 2 tbs flour";
    }
}
