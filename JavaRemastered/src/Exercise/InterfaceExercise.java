package Exercise;

import java.util.ArrayList;
import java.util.List;

interface ISaveable{
    List<String> write();
    void read(List<String> stringList);
}

class Player implements ISaveable{
    String name;
    String weapon;
    int hitPoints;
    int strength;

    List<String> ans = new ArrayList<>();

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        return ans;
    }

    @Override
    public void read(List<String> stringList) {
        ans.add(name);
        ans.add(Integer.toString(hitPoints));
        ans.add(Integer.toString(strength));
        ans.add(weapon);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints='" + hitPoints + '\'' +
                ", strength=" + strength +
                ", weapon=" + weapon +
                '}';
    }
}

class Monster implements ISaveable{
    String name;
    int hitPoints;
    int strength;

    List<String> ans = new ArrayList<>();

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public List<String> write() {
        return ans;
    }

    @Override
    public void read(List<String> stringList) {
        ans.add(name);
        ans.add(Integer.toString(hitPoints));
        ans.add(Integer.toString(strength));
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}

public class InterfaceExercise {
}
