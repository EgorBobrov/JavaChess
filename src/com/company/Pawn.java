package com.company;


/**
 * Created by Egor_Bobrov on 29-Feb-16.
 */
public class Pawn extends ChessPiece {

    public Pawn(boolean isWhite, int pos1, int pos2) {
        super(isWhite, pos1, pos2);
    }

    boolean isMoveValid(ChessPiece[][] board, Position newPosition) {
        if ((current.getPos1() == newPosition.getPos1()) && (current.getPos2() == newPosition.getPos2())) return false;
        if (this.isWhite()) {
            if ((newPosition.getPos1() == current.getPos1() - 1)
                    && (((newPosition.getPos2() == current.getPos2() + 1)) || newPosition.getPos2() == current.getPos2() - 1)
                    && board[newPosition.getPos1()][newPosition.getPos2()] != null
                    && board[newPosition.getPos1()][newPosition.getPos2()].isWhite() != this.isWhite()) {
                return true;
            }
            if ((newPosition.getPos1() == current.getPos1() - 1) && (board[newPosition.getPos1()][newPosition.getPos2()] == null)) {
                return true;
            }
            if ((current.getPos1() == 6) && newPosition.getPos1() == 4) return true;
        }
        else {
            if ((newPosition.getPos1() == current.getPos1() + 1)
                    && (((newPosition.getPos2() == current.getPos2() + 1)) || newPosition.getPos2() == current.getPos2() - 1)
                    && board[newPosition.getPos1()][newPosition.getPos2()] != null
                    && board[newPosition.getPos1()][newPosition.getPos2()].isWhite() != this.isWhite()) {
                return true;
            }
            if ((newPosition.getPos1() == current.getPos1() + 1) && (board[newPosition.getPos1()][newPosition.getPos2()] == null)) {
                return true;
            }
            if ((current.getPos1() == 1) && newPosition.getPos1() == 3) return true;

        }
        return false;
    }

}
