package com.javachess;



import java.util.ArrayList;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        // to close Scanner in any case I use try-with-resources
        try(Scanner scanner = new Scanner(System.in)) {
            // start the new game
            Game game = new Game();
            // list of players to iterate
            ArrayList<Player> players = game.getPlayers();

            // players make turns until checkmate
            while (!game.isGameOver()) {
                for (Player player : players) {
                    player.beginTurn();
                    System.out.println(player + " player turn.");
                    System.out.println("This is the current situation:");
                    // prints the board
                    printChess(game);
                    // player tries to make a move until it's successful
                    while (!player.endedTurn()) {
                        Position from;
                        Position to;
                        System.out.println("Please enter your turn in 'E2 E4' format (without quotes).");
                        // player enters something like "E2 E4", "B8 C6" etc. - a capital letter + a number
                        String fromString = scanner.next();
                        String toString = scanner.next();
                        from = new Position(fromString);
                        to = new Position(toString);
                        // game tries to execute the move or tell why it can't
                        game.executeMove(player, from, to);
                        // checking that both kings are present
                        game.checkGameover();
                    }
                }
            }
        }
    }



    public static void printChess(Game game) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(formatPrintChess(game.board[i][j]) + " ");
            }
            System.out.println();
        }

    }

    public static String formatPrintChess(ChessPiece chessPiece) {
        if (chessPiece == null) return "_";

        if (chessPiece.toString().equals("Pawn")) {
            return chessPiece.isWhite() ? "P" : "p";
        }
        if (chessPiece.toString().equals("Rook")) {
            return chessPiece.isWhite() ? "R" : "r";
        }
        if (chessPiece.toString().equals("Knight")) {
            return chessPiece.isWhite() ? "H" : "h";
        }
        if (chessPiece.toString().equals("Bishop")) {
            return chessPiece.isWhite() ? "B" : "b";
        }

        if (chessPiece.toString().equals("Queen")) {
            return chessPiece.isWhite() ? "Q" : "q";
        }
        if (chessPiece.toString().equals("King")) {
            return chessPiece.isWhite() ? "K" : "k";
        }
        return "";
    }

}
