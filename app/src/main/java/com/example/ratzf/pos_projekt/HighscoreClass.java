package com.example.ratzf.pos_projekt;

/**
 * Created by Patricia on 18.06.2016.
 */
public class HighscoreClass {
    String name;
    int points;

    public HighscoreClass(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {

        return name;
    }

    public int getPoints() {
        return points;
    }
}
