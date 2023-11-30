package prob3;

public class RedMartian extends Martian {

    private int tenacity;

    public RedMartian(int id, int tenacity) {
        this(id, 1, tenacity);
    }

    public RedMartian(int id, int volume, int tenacity) {
        super(id, volume);
        this.tenacity = tenacity;
    }

    public int getTenacity() {
        return tenacity;
    }

    @Override
    public int power() {
        return (2 * this.getVolume()) + tenacity;
    }

    @Override
    public String speak() {
        return "id=" + this.getId() + ", Rubldy Rock";
    }

    @Override
    public String toString() {
        return "Red Martian - id=" + this.getId() + ", vol=" + this.getVolume() + ", ten=" + tenacity;
    }
    
}
