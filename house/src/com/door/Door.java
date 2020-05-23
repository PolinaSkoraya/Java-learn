package com.door;

import java.io.Serializable;
import java.util.Objects;

public class Door implements Serializable {
    private String color;

    public Door(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder ("Door{");
        sb.append ("color='").append (color).append ('\'');
        sb.append ('}');
        return sb.toString ();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Door door = (Door) o;
        return Objects.equals (color, door.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash (color);
    }
}
