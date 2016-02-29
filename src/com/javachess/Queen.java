package com.javachess;


/**
 * Created by Egor_Bobrov on 29-Feb-16.
 */
public class Queen extends ChessPiece {

    public Queen (boolean isWhite, int pos1, int pos2) {
        super(isWhite, pos1, pos2);
    }


    @Override
    boolean isMoveValid(ChessPiece[][] board, Position newPosition) {
        int new1 = newPosition.getPos1();
        int new2 = newPosition.getPos2();
        int old1 = current.getPos1();
        int old2 = current.getPos2();

        if (new1 == old1 && new2 == old2) return false;
        if ((board[new1][new2] != null) && (board[new1][new2].isWhite() == this.isWhite())) return false;
        if ((new1 == old1) || (new2 == old2)) {
            if (new1 > old1) {
                for (int i = old1; i < new1; i++) {
                    if (board[i][old2] != null) return false;
                }
                return true;
            }
            if (new1 < old1) {
                for (int i = old1; i > new1; i--) {
                    if (board[i][old2] != null) return false;
                }
                return true;
            }

            if (new2 > old2) {
                for (int i = old2; i < new2; i++) {
                    if (board[old1][i] != null) return false;
                }
                return true;
            }
            if (new2 < old2) {
                for (int i = old2; i > new2; i--) {
                    if (board[old1][i] != null) return false;
                }
                return true;
            }
        }

        if ((Math.abs(old1 - new1)) != Math.abs(old2 - new2)) return false;

        if (new1 > old1 && new2 > old2) {
            for (int i = old1, j = old2; i < new1; i++, j++) {
                if (board[i][j] != null) return false;
            }
            return true;
        }
        else if (new1 > old1) {
            for (int i = old1, j = old2; i < new1; i++, j--) {
                if (board[i][j] != null) return false;
            }
            return true;
        }
        else if (new2 > old2) {
            for (int i = old1, j = old2; i > new1; i--, j++) {
                if (board[i][j] != null) return false;
            }
            return true;
        }
        else {
            for (int i = old1, j = old2; i < new1; i--, j--) {
                if (board[i][j] != null) return false;
            }
            return true;
        }
    }
}
