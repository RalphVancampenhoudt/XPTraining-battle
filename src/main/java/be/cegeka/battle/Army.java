package be.cegeka.battle;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Soldier> soldiers;
    public Army() {
        this.soldiers = new ArrayList<Soldier>();
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    public Soldier getFrontMan() {
        return soldiers.get(0);
    }
}
