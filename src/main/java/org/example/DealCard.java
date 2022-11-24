package org.example;

import java.util.ArrayList;

public class DealCard extends Card {


    public String getTopCard(ArrayList<Card> finalDeck) {
        int count=0;
        for (Card card : finalDeck) {
            if (count==0){
                count++;
//                System.out.println(card.getSuit() + card.getSymbol() + " " + card.getValue());
                return card.getSuit() + card.getSymbol() + " " + card.getValue();

            }


        }

        return "";




    }


}

