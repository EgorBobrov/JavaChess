package com.company;

/**
 * Created by Egor_Bobrov on 29-Feb-16.
 */
public class Position {
    private int pos1;
    private int pos2;

    public Position(int pos1, int pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public Position(Position old) {
        this.pos1 = old.getPos1();
        this.pos2 = old.getPos2();
    }

    public Position(String position) {
        this.pos2 = position.charAt(0) - 'A';
        this.pos1 = 7 - (position.charAt(1) - '1');
    }

    public int getPos1() {
        return pos1;
    }
    public int getPos2() {
        return pos2;
    }
}
