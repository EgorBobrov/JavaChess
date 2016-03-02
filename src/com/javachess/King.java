package com.javachess;


/**
 * Created by Egor_Bobrov on 29-Feb-16.
 */
public class King extends ChessPiece {

    public King(boolean isWhite, int pos1, int pos2) {
        super(isWhite, pos1, pos2);
    }


    @Override
    boolean isMoveValid(ChessPiece[][] board, Position newPosition) {
        int new1 = newPosition.getPos1();
        int new2 = newPosition.getPos2();
        int old1 = current.getPos1();
        int old2 = current.getPos2();

        if (new1 == old1 && new2 == old2) return false;
        if (board[new1][new2] != null && board[new1][new2].isWhite() == this.isWhite()) return false;

        // castling mechanic
        // castling short
        if (!this.hasMoved() && new2 == old2 + 2) {
            if (board[new1][new2 + 1] != null && board[new1][new2 + 1] instanceof Rook && !(board[new1][new2 - 2].hasMoved())) {
                if (board[new1][new2 + 1].isMoveValid(board, new Position(old1, old2 + 1))) {
                    board[new1][new2 + 1].changePos(old1, old2 + 1);
                    board[new1][new2 + 1].markMoved();
                    board[old1][old2 + 1] = board[new1][new2 + 1];
                    board[new1][new2 + 1] = null;
                    return true;
                }
            }
        }
        // castling long
        if (!this.hasMoved() && new2 == old2 - 2) {
            if ((board[new1][new2 - 2] != null) && (board[new1][new2 - 2] instanceof Rook) && !(board[new1][new2 - 2].hasMoved())) {
                if (board[new1][new2 - 2].isMoveValid(board, new Position(old1, old2 - 1))) {
                    board[new1][new2 - 2].changePos(old1, old2 + 1);
                    board[new1][new2 - 2].markMoved();
                    board[old1][old2 - 1] = board[new1][new2 - 2];
                    board[new1][new2 - 2] = null;
                    return true;
                }

            }
        }

        return ((new1 == old1 + 1) || (new1 == old1 - 1) || (new1 == old1)) && (new2 == old2 || new2 == old2 + 1 || new2 == old2 - 1);
    }
}
