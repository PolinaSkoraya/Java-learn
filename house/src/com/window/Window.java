package com.window;

import exceptions.CasementException;

import java.io.Serializable;
import java.util.Objects;

public class Window implements Serializable {
    private int numberOfCasement;

    public Window(int numberOfCasement) throws CasementException {
        if(numberOfCasement < 0) {
            throw new CasementException ("number of casements cannot be negative", numberOfCasement);
        }
        this.numberOfCasement = numberOfCasement;
    }

    public int getNumberOfCasement() {
        return numberOfCasement;
    }

    public void setNumberOfCasement(int numberOfCasement) {
        this.numberOfCasement = numberOfCasement;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder ("Window{");
        sb.append ("numberOfCasement=").append (numberOfCasement);
        sb.append ('}');
        return sb.toString ();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Window window = (Window) o;
        return numberOfCasement == window.numberOfCasement;
    }

    @Override
    public int hashCode() {
        return Objects.hash (numberOfCasement);
    }
}
