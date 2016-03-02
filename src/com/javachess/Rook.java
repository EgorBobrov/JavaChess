package com.javachess;



/**
 * Created by Egor_Bobrov on 29-Feb-16.
 */
public class Rook extends ChessPiece {

    public Rook (boolean isWhite, int pos1, int pos2) {
        super(isWhite, pos1, pos2);
    }



    @Override
    boolean isMoveValid(ChessPiece[][] board, Position newPosition) {
        int new1 = newPosition.getPos1();
        int new2 = newPosition.getPos2();
        int old1 = current.getPos1();
        int old2 = current.getPos2();
        if (new1 == old1 && new2 == old2) return false;

        if ((new1 != old1) && (new2 != old2)) return false;
        if ((board[new1][new2] != null) && (board[new1][new2].isWhite() == this.isWhite())) return false;

        if (new1 > old1) {
            for (int i = old1 + 1; i < new1; i++) {
                if (board[i][old2] != null) return false;
            }
        }
        if (new1 < old1) {
            for (int i = old1 - 1; i > new1; i--) {
                if (board[i][old2] != null) return false;
            }
        }

        if (new2 > old2) {
            for (int i = old2 + 1; i < new2; i++) {
                if (board[old1][i] != null) return false;
            }
        }
        if (new2 < old2) {
            for (int i = old2 - 1; i > new2; i--) {
                if (board[old1][i] != null) return false;
            }
        }
        return true;
    }
}
