package com.javachess;

/**
 * Created by Egor_Bobrov on 02-Mar-16.
 */
public class enPassant extends ChessPiece {

    public enPassant (boolean isWhite, int pos1, int pos2) {
        super(isWhite, pos1, pos2);
    }

    @Override
    boolean isMoveValid(ChessPiece[][] board, Position newPosition) {
        return false;
    }
}
