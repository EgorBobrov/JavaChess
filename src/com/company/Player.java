package com.company;

/**
 * Created by Egor_Bobrov on 29-Feb-16.
 */
public class Player {

    private final boolean isWhite;

    private boolean endTurn = false;

    public Player (boolean isWhite) {
        this.isWhite = isWhite;
    }

    public String toString() {
        if (isWhite) {
            return "White";
        }
        else return "Black";
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public boolean endedTurn() {
        return this.endTurn;
    }

    public void beginTurn() {
        this.endTurn = false;
    }
    public void endTurn() {
        this.endTurn = true;
    }

}
