package prob2;

public class GreenMartian extends Martian implements Teleporter {
    
    public GreenMartian(int id) { this(id, 1); }

    public GreenMartian(int id, int volume) { super(id, volume); }

    @Override
    public String speak() {
        return "id=" + this.getId() + ", Grobldy Grock";
    }

    @Override
    public String teleport(String dest) {
        return "id=" + this.getId() + " teleporting to " + dest;
    }

    @Override
    public String toString() {
        return "Green Martian - id=" + this.getId() + ", vol=" + this.getVolume();
    }

}
