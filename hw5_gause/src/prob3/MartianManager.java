package prob3;

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
                if (!killedMartians.contains(martian) && invader.power() > martian.power()) {
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

    public void absorbColony(ArrayList<Martian> colony) {
        martians.addAll(colony);
    }

    public ArrayList<Martian> captureInvaders(ArrayList<Martian> invaders) {
        if (martians.size() <= 0 || invaders.size() <= 0) { return null; }

        ArrayList<Martian> addedInvaders = new ArrayList<>();
        int totalMartianPower = 0;
        double averageMartianPower = 0.0;

        for (Martian martian : martians) {
            totalMartianPower += martian.power();
        }

        averageMartianPower = totalMartianPower / martians.size();

        for (Martian invader : invaders) {
            if (invader.power() > averageMartianPower) {
                addedInvaders.add(invader);
            }
        }

        martians.addAll(addedInvaders);
        
        return addedInvaders;
    }

    @Override
    public String toString() {
        return martians.toString();
    }

}
