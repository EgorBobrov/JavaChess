package com.javachess;



/**
 * Created by Egor_Bobrov on 29-Feb-16.
 */
public abstract class ChessPiece {
    private boolean isWhite;
    protected boolean moved;
    Position current;
    Position old;

    public void changePos(int x, int y) {
        this.old = new Position(this.current);
        this.current = new Position(x, y);
    }

    abstract boolean isMoveValid(ChessPiece[][] board, Position newPosition);

    public ChessPiece(boolean isWhite, int pos1, int pos2) {
        this.isWhite = isWhite;
        this.current = new Position(pos1, pos2);
        this.moved = false;
    }

    public boolean hasMoved() {
        return this.moved;
    }

    public void markMoved() {
        this.moved = true;
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }

    public boolean isWhite() {
        return this.isWhite;
    }
}
