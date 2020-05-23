package com.house;

import com.door.Door;
import com.window.Window;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class House implements Serializable {
    private ArrayList<Door> doors;
    private ArrayList<Window> windows;
    private transient boolean closed = false;
    private static int numberOfTheHouse;

    public House (ArrayList<Door> doors, ArrayList<Window> windows) {
        this.doors = doors;
        this.windows = windows;
    }

    public boolean isClosed() {
        return closed;
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    public ArrayList<Window> getWindows() {
        return windows;
    }

    public void addDoor (Door door) {
        this.doors.add (door);
    }

    public void addWindow (Window window) {
        this.windows.add (window);
    }

    public static void setNumberOfTheHouse(int numberOfTheHouse) {
        House.numberOfTheHouse = numberOfTheHouse;
    }

    public static int getNumberOfTheHouse() {
        return numberOfTheHouse;
    }

    public void showNumberOfWidowsAndDoors () {
        System.out.println ("number of windows: " + this.windows.size () + ", number of doors: " + this.doors.size ());
    }

    public void close() {
        this.closed = true;
    }

    public static int getRandom (int from, int to) {
        Random random = new Random ();
        return (from + random.nextInt(to - from));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder ("House{");
        sb.append ("doors=").append (doors);
        sb.append (", windows=").append (windows);
        sb.append (", closed=").append (closed);
        sb.append ('}');
        return sb.toString ();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        House house = (House) o;
        return  closed == house.closed &&
                doors.equals (house.doors) &&
                windows.equals (house.windows);
    }

    @Override
    public int hashCode() {
        return Objects.hash (doors, windows, closed);
    }
}
