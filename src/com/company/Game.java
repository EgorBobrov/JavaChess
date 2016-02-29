package com.company;

import java.util.ArrayList;

/**
 * Created by Egor_Bobrov on 29-Feb-16.
 */
public class Game {

    // game board
    public ChessPiece[][] board = new ChessPiece[8][8];

    // positions at the start of the game
    private void fillBoard() {
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(false, 1, i);
        }
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(true, 6, i);
        }
        board[0][0] = new Rook(false, 0, 0);
        board[0][1] = new Knight(false, 0, 1);
        board[0][2] = new Bishop(false, 0, 2);
        board[0][3] = new Queen(false, 0, 3);
        board[0][4] = new King(false, 0, 4);
        board[0][5] = new Bishop(false, 0, 5);
        board[0][6] = new Knight(false, 0, 6);
        board[0][7] = new Rook(false, 0, 7);

        board[7][0] = new Rook(true, 7, 0);
        board[7][1] = new Knight(true, 7, 1);
        board[7][2] = new Bishop(true, 7, 2);
        board[7][3] = new Queen(true, 7, 3);
        board[7][4] = new King(true, 7, 4);
        board[7][5] = new Bishop(true, 7, 5);
        board[7][6] = new Knight(true, 7, 6);
        board[7][7] = new Rook(true, 7, 7);
    }

    private ArrayList<Player> players = new ArrayList<>();

    private boolean isOver = false;

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public boolean isGameOver() {
        return this.isOver;
    }

    public void gameOver() {
        this.isOver = true;
    }

    // constructor fills game board and creates two players
    public Game() {
        fillBoard();
        players.add(new Player(true));
        players.add(new Player(false));
    }


    public void executeMove(Player player, Position from, Position to) {
        // checking coordinates are valid
        if (from.getPos1() < 0 || from.getPos1() > 7 || from.getPos2() < 0 || from.getPos2() > 7) {
            System.out.println("Invalid starting position.");
            return;
        }
        if (to.getPos1() < 0 || to.getPos1() > 7 || to.getPos2() < 0 || to.getPos2() > 7) {
            System.out.println("Invalid end position.");
            return;
        }
        ChessPiece currentPiece = board[from.getPos1()][from.getPos2()];
        // if there is no chess piece at the "from" position or the chess piece does not belong to current player
        if(currentPiece == null || currentPiece.isWhite() != player.isWhite()) {
            System.out.println("No your chess piece at that position. Please enter valid start coordinates.");
            return;
        }
        // if it is not possible to move to the new position (logic is checked by the relevant chess piece)
        if(!currentPiece.isMoveValid(this.board, to)) {
            System.out.println("Invalid move. Please enter valid end coordinates.");
            return;
        }
        // if everything is fine, we move the chess piece
        currentPiece.changePos(to.getPos1(), to.getPos2());
        board[to.getPos1()][to.getPos2()] = currentPiece;
        board[currentPiece.old.getPos1()][currentPiece.old.getPos2()] = null;
        player.endTurn();
    }

    public void checkGameover() {
        boolean whiteKingAlive = false;
        boolean blackKingAlive = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(this.board[i][j] != null) {
                    if (this.board[i][j].toString().equals("King")) {
                        if (this.board[i][j].isWhite()) whiteKingAlive = true;
                        else blackKingAlive = true;
                    }
                }
            }
        }
        if(!whiteKingAlive) {
            System.out.println("Black player wins!");
            this.gameOver();
        }
        if (!blackKingAlive) {
            System.out.println("White player wins!");
            this.gameOver();
        }

    }
}
