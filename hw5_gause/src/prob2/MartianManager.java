package prob2;

import java.util.ArrayList;

public class MartianManager {

    protected ArrayList<Martian> martians = new ArrayList<>();
    protected ArrayList<Teleporter> teleporters = new ArrayList<>();

    public MartianManager() {}

    public boolean addMartian(Martian m) {
        if (martians.contains(m)) { return false; }

        martians.add(m);

        if (m instanceof Teleporter) {
            teleporters.add((Teleporter) m);
        }

        return true;
    }

    public ArrayList<Martian> battle(ArrayList<Martian> invaders) {
        ArrayList<Martian> killedMartians = new ArrayList<Martian>();

        for (Martian invader : invaders) {
            for (Martian martian : martians){
                
                // If statement runs validates when current martian hasn't already been killed, and invader power is greater than martians
                if (!killedMartians.contains(martian) && getPower(invader) > getPower(martian)) {
                    killedMartians.add(martian);
                    martians.remove(martian);
                    if (martian instanceof Teleporter) { teleporters.remove((Teleporter) martian); }
                    break;
                }
            }
        }

        return killedMartians;
    }

    public boolean contains(int id) {
        Martian dummyMartian = new GreenMartian(id);

        return (martians.contains(dummyMartian));
    }

    public Martian getMartianAt(int i) {
        return (i < 0 || i >= martians.size()) ? null : martians.get(i);
    }

    public Martian getMartianClosestTo(int id) {
        Martian closestMartian = martians.get(0);

        for (Martian martian : martians) {
            if ((Math.abs(martian.getId() - id)) < (Math.abs(closestMartian.getId() - id))) {
                closestMartian = martian;
            }
        }

        return closestMartian;
    }

    public Martian getMartianClosestTo(Martian martian) {
        return getMartianClosestTo(martian.getId());
    }

    public Martian getMartianWithId(int id) {
        Martian dummyMartian = new GreenMartian(id);

        int indexOfMartian = martians.indexOf(dummyMartian);

        return (indexOfMartian == -1) ? null : martians.get(indexOfMartian);
    }

    public int getNumMartians() {
        return martians.size();
    }

    public int getNumTeleporters() {
        return teleporters.size();
    }

    private int getPower(Martian m) {
        return (m instanceof GreenMartian) ? m.getVolume() : (m.getVolume() + ((RedMartian)m).getTenacity());
    }

    public ArrayList<Martian> getSortedMartians() {
        ArrayList<Martian> sortedMartians = new ArrayList<>(martians);

        sortedMartians.sort(null);
        
        return sortedMartians;
    }

    public Teleporter getTeleporterAt(int i) {
        if (i < 0 || i >= teleporters.size()) { return null; }
        return teleporters.get(i);
    }

    public String groupSpeak() {
        StringBuilder msg = new StringBuilder();

        for (Martian martian : martians) {
            msg.append(martian.speak() + "\n");
        }

        return msg.toString();
    }

    public String groupTeleport(String dest) {
        StringBuilder msg = new StringBuilder();

        for (Teleporter teleporter : teleporters) {
            msg.append(teleporter.teleport(dest) + "\n");
        }

        return msg.toString();
    }

    public void obliterateTeleporters() {
        for (Teleporter t : teleporters) {
            martians.remove((Martian) t);
        }
        teleporters.clear();
    }

    public Martian removeMartian(int id) {
        Martian martianToRemove = getMartianWithId(id);

        martians.remove(martianToRemove);

        if (martianToRemove instanceof Teleporter) { teleporters.remove((Teleporter) martianToRemove); }

        return (martianToRemove == null) ? null : martianToRemove;
    }

    @Override
    public String toString() {
        return martians.toString();
    }

}
