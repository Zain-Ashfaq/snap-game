package org.example;

import java.util.*;

public class Deck {


    Random random = new Random();

    private List<String> suit = new ArrayList<>();
    private List<String> symbol = new ArrayList<>();
    private int[] value = new int[13];

    private ArrayList<Card> finalDeck = new ArrayList<>();
    private int upperBoundSuit;
    private int upperBoundSymbol;
    private int upperBoundValue;


    Deck() {

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
        upperBoundSuit = suit.size();
        upperBoundSymbol = symbol.size();
        upperBoundValue = value.length;


    }

    public void assembleDeck() {
        for (int i = 0; i < 52; i++) {
            int int_random_suit = random.nextInt(upperBoundSuit);
            int int_random_symbol = random.nextInt(upperBoundSymbol);
            int int_random_value = random.nextInt(upperBoundValue);

            finalDeck.add(new Card(suit.get(int_random_suit), symbol.get(int_random_symbol), value[int_random_value]));

        }


    }

    public String dealCard() {
        Card tempCard = finalDeck.get(0);
        String tempCardSymbol = dealCardSymbol(tempCard);
        finalDeck.remove(0);
        System.out.println("this is temp card" + tempCard.getSuit() + " " + tempCard.getSymbol() + " " + tempCard.getValue());
        return "this is symbol " + tempCardSymbol;


    }

    public String dealCardSymbol(Card currentCard) {
        return currentCard.getSymbol();
    }

    public int sizeOfDeck() {
        return finalDeck.size();
    }


    @Override
    public String toString() {
        for (Card card : finalDeck) {
            System.out.println(card.getSuit() + card.getSymbol() + " " + card.getValue());

        }

        return null;
    }

    public void sortDeckInNumberOrder() {
        Collections.sort(finalDeck);
    }

    public void shuffleDeck() {
        Collections.shuffle(finalDeck);
    }


}
