package com.company;



/**
 * Created by Egor_Bobrov on 29-Feb-16.
 */
public class Bishop extends ChessPiece {

    public Bishop (boolean isWhite, int pos1, int pos2) {
        super(isWhite, pos1, pos2);
    }



    @Override
    boolean isMoveValid(ChessPiece[][] board, Position newPosition) {
        int new1 = newPosition.getPos1();
        int new2 = newPosition.getPos2();
        int old1 = current.getPos1();
        int old2 = current.getPos2();

        if ((new1 == old1) || (new2 == old2)) return false;
        if ((board[new1][new2] != null) && (board[new1][new2].isWhite() == this.isWhite())) return false;

        if ((Math.abs(old1 - new1)) != Math.abs(old2 - new2)) return false;

        if (new1 > old1 && new2 > old2) {
            for (int i = old1, j = old2; i < new1; i++, j++) {
                if (board[i][j] != null) return false;
            }
        }
        else if (new1 > old1) {
            for (int i = old1, j = old2; i < new1; i++, j--) {
                if (board[i][j] != null) return false;
            }
        }
        else if (new2 > old2) {
            for (int i = old1, j = old2; i > new1; i--, j++) {
                if (board[i][j] != null) return false;
            }
        }
        else {
            for (int i = old1, j = old2; i < new1; i--, j--) {
                if (board[i][j] != null) return false;
            }
        }

        return true;
    }
}
