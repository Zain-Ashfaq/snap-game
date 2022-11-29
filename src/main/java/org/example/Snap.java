package org.example;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Snap {

    private boolean hasGameEnded = false;
    private boolean isTwoPlayer = false;
    private boolean isPlayerOneTurn = true;


    Scanner userInput = new Scanner(System.in);


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
                    System.out.println(Colours.ANSI_RED_BACKGROUND + Colours.ANSI_BLACK + "Please only press enter to draw a card" + Colours.ANSI_RESET);
                    pressEnter = userInput.nextLine();
                }


                if (card1.equals(card2)) {
                    System.out.println(card2);
                    System.out.println("You have won Snap game");

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


                for (int i = 0; i < firstDeck.sizeOfDeck(); i++) {
                    System.out.println(firstDeck.sizeOfDeck());
                    System.out.println("Please press enter to draw card");
                    String pressEnter = userInput.nextLine();
                    while (!pressEnter.equals("")) {
                        System.out.println(Colours.ANSI_RED_BACKGROUND + Colours.ANSI_BLACK + "Please only press enter to draw a card" + Colours.ANSI_RESET);
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
                        long timeMillisBefore = System.currentTimeMillis();
                        long beforeSnap = TimeUnit.MILLISECONDS.toSeconds(timeMillisBefore);

                        System.out.println(Colours.ANSI_GREEN_BACKGROUND + Colours.ANSI_BLACK + "Enter word snap in 2 seconds to win" + Colours.ANSI_RESET);
                        String enterSnap = userInput.nextLine();
                        long timeMillisAfter = System.currentTimeMillis();

                        long afterSnap = TimeUnit.MILLISECONDS.toSeconds(timeMillisAfter);
                        long timeDifference = afterSnap - beforeSnap;


                        System.out.println("Your time was " + Colours.ANSI_RED_BACKGROUND + Colours.ANSI_BLACK + timeDifference + Colours.ANSI_RESET + " seconds");


                        if (afterSnap - beforeSnap <= 2 && enterSnap.trim().toLowerCase().equals("snap")) {

                            System.out.println("You have won Snap game");


                            String whichPlayerWon = isPlayerOneTurn ? "Player one wins" : "Player two wins";
                            System.out.println(whichPlayerWon);


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
