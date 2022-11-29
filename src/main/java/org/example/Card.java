package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Card implements Comparable<Card> {
    private String suit;
    private String symbol;
    private int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public Card() {

    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public int compareTo(Card o) {
        int first = 0;
        int second = 0;
        switch (getSuit()) {
            // heart
            case "\u2665":
                first = 1;
                break;
            case "\u2663": // Club
                first = 2;
                break;
            case "\u2660": // Spade
                first = 3;
                break;
            case "\u25C6": //Diamond
                first = 4;
                break;
        }
        switch (o.getSuit()) {
            // heart
            case "\u2665":
                second = 1;
                break;
            case "\u2663": // Club
                second = 2;
                break;
            case "\u2660": // Spade
                second = 3;
                break;
            case "\u25C6": //Diamond
                second = 4;
                break;
        }
        int result = Integer.compare(first, second);

        switch (result) {
            case 1:
                return 1;
            case -1:
                return -1;
            case 0:
                return Integer.compare(getValue(), o.getValue());
        }

        return 0;
    }


}
