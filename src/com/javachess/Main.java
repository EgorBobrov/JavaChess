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
                playing: {
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
                            game.checkGameOver(player);
                            if (game.isGameOver()) break playing;
                        }
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

        switch (chessPiece.toString()) {
            case "Pawn":
                return chessPiece.isWhite() ? "P" : "p";
            case "Rook":
                return chessPiece.isWhite() ? "R" : "r";

            case "Knight":
                return chessPiece.isWhite() ? "H" : "h";

            case "Bishop":
                return chessPiece.isWhite() ? "B" : "b";

            case "Queen":
                return chessPiece.isWhite() ? "Q" : "q";

            case "King":
                return chessPiece.isWhite() ? "K" : "k";

            case "enPassant":
                return "*";
            }
        return "";
    }

}
