package org.example;


import java.util.ArrayList;

import static org.example.CardRandomInfo.finalDeck;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Testing github changes");
        CardRandomInfo test = new CardRandomInfo();
        test.randomSymbol();
        System.out.println(test.toString());
        DealCard get = new DealCard();
        System.out.println(get.getTopCard(finalDeck));


    }
}