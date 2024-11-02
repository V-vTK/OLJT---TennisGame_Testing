// package com.example;

// public class Main {
//     public static void main(String[] args) {
//         System.out.println("Hello world!");
//         System.out.println("Hello world!");
//         TennisGame game = new TennisGame();
        
//         try {
//             game.player1Scored();
//             System.out.println(game.getScore());
            
//             game.player2Scored();
//             System.out.println(game.getScore()); //"15 - 15"
            
//             game.player1Scored();
//             System.out.println(game.getScore()); // "30 - 15"
            
//             game.player2Scored();
//             System.out.println(game.getScore()); //"30 - 30"
            
//             game.player1Scored();
//             System.out.println(game.getScore()); //"40 - 30"
            
//             game.player1Scored();
//             System.out.println(game.getScore()); //"player1 wins"
            
//             game.player2Scored(); // error
//         } catch (TennisGameException e) {
//             System.out.println("Game has already ended. Cannot score.");
//         }
//     }
// }