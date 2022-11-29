package org.example;

import java.util.ArrayList;

public class Snap {

    private boolean hasGameEnded = false;


    public boolean isHasGameEnded() {
        return hasGameEnded;
    }

    public void setHasGameEnded(boolean hasGameEnded) {
        this.hasGameEnded = hasGameEnded;
    }

    public static void main(String[] args) {


        Deck firstDeck = new Deck();
        Snap snap = new Snap();
        firstDeck.assembleDeck();
        while (snap.isHasGameEnded() == false) {
            System.out.println("test");
            String card1 = firstDeck.dealCard();
            String card2 = firstDeck.dealCard();
            for (int i = 0; i < 52; i++) {

                if (card1.equals(card2)) {
                    System.out.println("You have won Snap game");
                    System.out.println("how many times " + i);
                    snap.setHasGameEnded(true);
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
