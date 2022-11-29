package org.example;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;

public class Snap {

    private boolean hasGameEnded = false;
    private boolean isTwoPlayer = false;
    private boolean isPlayerOneTurn = true;
    Scanner userInput = new Scanner(System.in);
    Date date = new Date();



    public boolean isTwoPlayer() {
        return isTwoPlayer;
    }

    public void setTwoPlayer(boolean twoPlayer) {
        isTwoPlayer = twoPlayer;
    }

    public boolean isHasGameEnded() {
        return hasGameEnded;
    }

    public void setHasGameEnded(boolean hasGameEnded) {
        this.hasGameEnded = hasGameEnded;
    }

    private void gameLogicSinglePlayer() {
        Deck firstDeck = new Deck();

        firstDeck.assembleDeck();
        while (isHasGameEnded() == false) {
            System.out.println("test");
            String card1 = firstDeck.dealCard();
            String card2 = firstDeck.dealCard();

            for (int i = 0; i < 52; i++) {
                System.out.println("Please press enter to draw card");
                String pressEnter = userInput.nextLine();
                while (!pressEnter.equals("")) {
                    System.out.println("Please press enter to draw card");
                    pressEnter = userInput.nextLine();
                }


                if (card1.equals(card2)) {
                    System.out.println(card2);
                    System.out.println("You have won Snap game");
                    System.out.println("how many times " + i);
                    setHasGameEnded(true);
                    return;
                } else {

                    card1 = card2;
                    card2 = firstDeck.dealCard();

                }
            }
            System.out.println(card1);

        }
    }

    private void gameLogicTwoPlayers() {

        {
            Deck firstDeck = new Deck();

            firstDeck.assembleDeck();
            while (isHasGameEnded() == false) {
                System.out.println("test");
                String card1 = firstDeck.dealCard();
                String card2 = firstDeck.dealCard();

                for (int i = 0; i < 52; i++) {
                    System.out.println("Please press enter to draw card");
                    String pressEnter = userInput.nextLine();
                    while (!pressEnter.equals("")) {
                        System.out.println("Please press enter to draw card");
                        pressEnter = userInput.nextLine();
                    }

                    if (i % 2 == 0) {
                        setTwoPlayer(true);
                        System.out.println("Player two turn");
                    } else {
                        setTwoPlayer(false);
                        System.out.println("Player one turn");
                    }


                    if (card1.equals(card2)) {
                        long beforeSnap = date.getTime();
                        System.out.println("Enter snap in 2 seconds to win");
                        String enterSnap = userInput.nextLine();

                        long afterSnap = date.getTime();
                        System.out.println(beforeSnap +"  "+afterSnap);

                        if (afterSnap - beforeSnap >= 200000 && enterSnap.toLowerCase()=="snap") {
                            System.out.println(card2);
                            System.out.println("You have won Snap game");
                            System.out.println("how many times " + i);
                            if (isPlayerOneTurn) {
                                System.out.println("Player one wins");
                            } else {
                                System.out.println("Player two wins");
                            }

                        } else {
                            System.out.println("Sorry you didnt type snap in under two seconds.");
                        }

                        setHasGameEnded(true);
                        return;
                    } else {

                        card1 = card2;
                        card2 = firstDeck.dealCard();

                    }
                }
                System.out.println(card1);

            }
        }

    }

    public void StartGame(boolean isTwoPlayer) {


        if (isTwoPlayer == false) {
            gameLogicSinglePlayer();
        } else {
            gameLogicTwoPlayers();

        }


    }

    public static void main(String[] args) {
        Snap snap = new Snap();
        snap.StartGame(true);


    }

}
