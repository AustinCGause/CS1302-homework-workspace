package prob1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MartianManager {

    protected HashMap<Integer, Martian> martians = new HashMap<>();
    protected HashMap<Integer, Teleporter> teleporters = new HashMap<>();

    public MartianManager() {
    }

    public boolean addMartian(Martian m) {
        if (martians.containsValue(m)) {
            return false;
        }

        martians.put(m.getId(), m);

        if (m instanceof Teleporter) {
            teleporters.put(m.getId(), (Teleporter) m);
        }

        return true;
    }

    public ArrayList<Martian> battle(ArrayList<Martian> invaders) {
        ArrayList<Martian> killedMartians = new ArrayList<Martian>();

        for (Martian invader : invaders) {
            for (Martian martian : martians.values()) {

                // If statement validates when current martian hasn't already been killed,
                // and invader power is greater than martians
                if (!killedMartians.contains(martian) && invader.power() > martian.power()) {

                    killedMartians.add(martian);
                    martians.remove(martian.getId());

                    if (martian instanceof Teleporter) {
                        teleporters.remove(martian.getId());
                    }

                    break;
                }
            }
        }

        return killedMartians;
    }

    public boolean contains(int id) {
        return (martians.containsKey(id));
    }

    // public Martian getMartianClosestTo(int id) {
    // Martian closestMartian = martians;

    // for (Martian martian : martians) {
    // if ((Math.abs(martian.getId() - id)) < (Math.abs(closestMartian.getId() -
    // id))) {
    // closestMartian = martian;
    // }
    // }

    // return closestMartian;
    // }

    // public Martian getMartianClosestTo(Martian martian) {
    // return getMartianClosestTo(martian.getId());
    // }

    public Martian getMartian(int id) {
        return martians.get(id);
    }

    public int getNumMartians() {
        return martians.size();
    }

    public int getNumTeleporters() {
        return teleporters.size();
    }

    public ArrayList<Martian> getSortedMartians(String sortType) {
        ArrayList<Martian> sortedMartians = new ArrayList<>(martians.values());

        MartianIdComparator martianIdComparator = new MartianIdComparator();
        MartianVolumeComparator martianVolumeComparator = new MartianVolumeComparator();

        if (sortType == "ID") {
            sortedMartians.sort(martianIdComparator);
        } else {
            sortedMartians.sort(martianVolumeComparator);
        }

        return sortedMartians;
    }

    public Teleporter getTeleporter(int id) {
        return teleporters.get(id);
    }

    public String groupSpeak() {
        StringBuilder msg = new StringBuilder();

        for (Martian martian : martians.values()) {
            msg.append(martian.speak() + "\n");
        }

        return msg.toString();
    }

    public String groupTeleport(String dest) {
        StringBuilder msg = new StringBuilder();

        for (Teleporter teleporter : teleporters.values()) {
            msg.append(teleporter.teleport(dest) + "\n");
        }

        return msg.toString();
    }

    public void increaseTeleporterVolume(int idThreshold) {

        for (Teleporter teleporter : teleporters.values()) {
            if (((Martian) teleporter).getVolume() < idThreshold) {
                ((Martian) teleporter).setVolume(((Martian)teleporter).getVolume() + 1);
            }
        }

    }

    public void obliterateTeleporters() {
        Iterator<Martian> iterator = martians.values().iterator();

        while (iterator.hasNext()) {
            if (iterator.next() instanceof Teleporter) {
                iterator.remove();
            }
        }

        teleporters.clear();
    }

    public Martian removeMartian(int id) {
        Martian martianToRemove = getMartian(id);

        martians.remove(id);

        if (martianToRemove instanceof Teleporter) {
            teleporters.remove(id);
        }

        return (martianToRemove == null) ? null : martianToRemove;
    }

    // public void absorbColony(ArrayList<Martian> colony) {
    // martians.addAll(colony);
    // }

    public ArrayList<Martian> captureInvaders(ArrayList<Martian> invaders) {
        if (martians.size() <= 0 || invaders.size() <= 0) {
            return null;
        }

        ArrayList<Martian> addedInvaders = new ArrayList<>();
        int totalMartianPower = 0;
        double averageMartianPower = 0.0;

        for (Martian martian : martians.values()) {
            totalMartianPower += martian.power();
        }

        averageMartianPower = totalMartianPower / martians.size();

        for (Martian invader : invaders) {
            if (invader.power() > averageMartianPower) {
                addedInvaders.add(invader);
                martians.put(invader.getId(), invader);
            }
        }

        return addedInvaders;
    }

    @Override
    public String toString() {
        return martians.values().toString();
    }

}
