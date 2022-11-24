package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardRandomInfo {
    PrintWriter printWriter = new PrintWriter(System.out, true);

    Random random = new Random();

    static List<String> suit = new ArrayList<>();
    static List<String> symbol = new ArrayList<>();
    static int[] value = new int[13];

    static ArrayList<Card> finalDeck = new ArrayList<>();
    int upperBoundSuit=suit.size();
    int upperBoundSymbol = symbol.size();
    int upperBoundValue = value.length;



    static {
        //heart
        suit.add("\u2665");
        //club
        suit.add("\u2663");
        //spade
        suit.add("\u2660");
        //diamond
        suit.add("\u25C6");
        //Symbol
        symbol.add("2");
        symbol.add("3");
        symbol.add("4");
        symbol.add("5");
        symbol.add("6");
        symbol.add("7");
        symbol.add("8");
        symbol.add("9");
        symbol.add("10");
        symbol.add("J");
        symbol.add("Q");
        symbol.add("K");
        symbol.add("A");
        //Int value
        for (int i = 0; i < value.length; i++) {
            value[i] = i + 2;
        }



    }

    public void randomSymbol() {
        for (int i = 0; i < 40; i++) {
            int int_random_suit = random.nextInt(upperBoundSuit);
            int int_random_symbol = random.nextInt(upperBoundSymbol);
            int int_random_value = random.nextInt(upperBoundValue);

            finalDeck.add(new Card(suit.get(int_random_suit), symbol.get(int_random_symbol), value[int_random_value]));

        }


    }


    @Override
    public String toString() {
        for (Card card : finalDeck) {
            System.out.println(card.getSuit() + card.getSymbol() + " " + card.getValue());
//            printWriter.println(card);


        }
        return "";
    }
}
