package com.epam.rd.autocode.startegy.cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardDealingStrategies {
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>> stacks = new HashMap<>();
            List<Card> communityStack = new ArrayList<>();

            // Her bir oyuncuya ikişer kart dağıtılır
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < players; j++) {
                    String playerName = "Player " + (j + 1);
                    List<Card> playerHand = stacks.getOrDefault(playerName, new ArrayList<>());

                    // Bir kart alınır ve oyuncunun eline eklenir
                    Card card = deck.dealCard();
                    playerHand.add(card);

                    // Güncellenen oyuncu eli destelere eklenir
                    stacks.put(playerName, playerHand);
                }
            }

            // Beş kart communityStack'e eklenir
            for (int i = 0; i < 5; i++) {
                Card card = deck.dealCard();
                communityStack.add(card);
            }
            stacks.put("Community", communityStack);


            List<Card> remainingCards = deck.restCards();
            stacks.put("Remaining", remainingCards);

            return stacks;
        };
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>> stacks = new HashMap<>();
            int cardsPerPlayer = 5;
            for (int i = 0; i < cardsPerPlayer; i++) {
                for (int j = 0; j < players; j++) {
                    String playerName = "Player " + (j + 1);
                    List<Card> playerHand = stacks.getOrDefault(playerName, new ArrayList<>());

                    Card card = deck.dealCard();
                    playerHand.add(card);
                    stacks.put(playerName, playerHand);
                }
            }
            List<Card> remainingCards = deck.restCards();
            stacks.put("Remaining", remainingCards);
            return stacks;
        };

    }

    public static CardDealingStrategy bridgeCardDealingStrategy(){
        return (deck, players) -> {
            Map<String, List<Card>> stacks = new HashMap<>();
            int cardsPerPlayer = 13;

            for (int i = 0; i < cardsPerPlayer; i++) {
                for (int j = 0; j < players; j++) {
                    String playerName = "Player " + (j + 1);
                    List<Card> playerHand = stacks.getOrDefault(playerName, new ArrayList<>());

                    Card card = deck.dealCard();
                    playerHand.add(card);
                    stacks.put(playerName, playerHand);
                }
            }

            return stacks;
        };
    }

    public static CardDealingStrategy foolCardDealingStrategy(){
        return (deck, players) -> {
            Map<String, List<Card>> stacks = new HashMap<>();
            List<Card> trumpStack = new ArrayList<>();

            int cardsPerPlayer = 6;

            // Deal cards to each player
            for (int i = 0; i < cardsPerPlayer; i++) {
                for (int j = 0; j < players; j++) {
                    String playerName = "Player " + (j + 1);
                    List<Card> playerHand = stacks.getOrDefault(playerName, new ArrayList<>());

                    // Bir kart alınır ve oyuncunun eline eklenir
                    Card card = deck.dealCard();
                    playerHand.add(card);

                    // Güncellenen oyuncu eli destelere eklenir
                    stacks.put(playerName, playerHand);
                }
            }

            // Deal 1 card to the trump stack
            Card trumpCard = deck.dealCard();
            trumpStack.add(trumpCard);
            stacks.put("Trump card", trumpStack);

            // Add the remaining cards to the "Remaining" stack
            List<Card> remainingCards = deck.restCards();
            stacks.put("Remaining", remainingCards);

            return stacks;
        };


    }

}
