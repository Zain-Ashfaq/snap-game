package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Testing github changes");
        Card sortCard = new Card();
        Deck deck = new Deck();
        deck.assembleDeck();
        deck.toString();
        deck.sortDeckInNumberOrder();
        System.out.println("///////////////////////////");
        deck.toString();
        System.out.println(deck.dealCard());
        System.out.println("size of deck "+deck.sizeOfDeck());

        System.out.println("//////////////////////////////////////");
        deck.toString();
        deck.shuffleDeck();
        deck.toString();


    }
}