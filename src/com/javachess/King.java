package com.javachess;


/**
 * Created by Egor_Bobrov on 29-Feb-16.
 */
public class King extends ChessPiece {

    public King (boolean isWhite, int pos1, int pos2) {
        super(isWhite, pos1, pos2);
    }



    @Override
    boolean isMoveValid(ChessPiece[][] board, Position newPosition) {
        int new1 = newPosition.getPos1();
        int new2 = newPosition.getPos2();
        int old1 = current.getPos1();
        int old2 = current.getPos2();
        if (new1 == old1 && new2 == old2) return false;
        if(board[new1][new2] != null && board[new1][new2].isWhite() == this.isWhite()) return false;
        return ((new1 == old1 + 1) || (new1 == old1 - 1) || (new1 == old1)) && (new2 == old2 || new2 == old2 + 1 || new2 == old2 - 1);
    }
}
