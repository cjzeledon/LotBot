package com.theironyard.charlotte.lotbot;


import java.util.Arrays;

public class Lot {
    private static int NUM_CREATED = 0;
    private int id;
    private Space[] spaces;

    public Lot() {
    }

    public int getId(int id) {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Space[] getSpaces() {
        return spaces;
    }

    public void setSpaces(Space[] spaces) {
        this.spaces = spaces;
    }

    public static Lot createLot() {
        Lot l = new Lot();
        l.setId(NUM_CREATED++);
        l.setSpaces(new Space[30]);
        return l;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", spaces=" + Arrays.toString(spaces) +
                '}';
    }
}
