package com.main;

public class Bracket {
    private char openBrkt;
    private char closeBrkt;
    private boolean flagOpenBrkt = false;
    private boolean flagCloseBrkt = false;

    Bracket(char openBrkt, char closeBrkt) {
        this.openBrkt = openBrkt;
        this.closeBrkt = closeBrkt;
    }

    boolean isChageBrktCondition(char outerChar) {
        flagOpenBrkt = false;
        flagCloseBrkt = false;
        if (outerChar == openBrkt) {
            flagOpenBrkt = true;
            return true;
        }
        else if (outerChar == closeBrkt) {
            flagCloseBrkt = true;
            return true;
        }
        return false;
    }

    public char getOpenBrkt() {
        return openBrkt;
    }

    public char getCloseBrkt() {
        return closeBrkt;
    }

    public boolean isFlagOpenBrkt() {
        return flagOpenBrkt;
    }

    public boolean isFlagCloseBrkt() {
        return flagCloseBrkt;
    }
}
