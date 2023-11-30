package prob2;

public abstract class Martian extends Object implements Comparable<Martian> {
    
    private int id;
    private int volume;

    public Martian (int id, int volume) {
        this.id = id;
        this.volume = volume;
    }

    @Override
    public int compareTo(Martian m) {
        return Integer.compare(this.id, m.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || !(o instanceof Martian)) { return false; }

        return this.id == ((Martian) o).getId();
    }

    public int getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public abstract String speak();

    public String toString() {
        return "id=" + id + ", vol=" + volume;
    }

}
