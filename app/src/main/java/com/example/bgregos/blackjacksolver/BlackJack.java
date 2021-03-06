package com.example.bgregos.blackjacksolver;
import java.util.ArrayList;
public class BlackJack
{
    private Deck deck;
    private BJCardHand house;
    private BJCardHand player;

    public BlackJack(ArrayList<String> userSuit, ArrayList<String> userValue,
                     ArrayList<String> dealerSuit, ArrayList<String> dealerValue)
    {
        deck = new Deck();
        house = new BJCardHand();
        player = new BJCardHand();
        addCardsForPlayer(userSuit, userValue);
        addCardsForDealer(dealerSuit, dealerValue);
    }

    public void addCardsForPlayer(ArrayList<String> userSuit, ArrayList<String> userValue)
    {
        for (int i = 0; i < userSuit.size(); i++)
        {
            addPlayerCard(userSuit.get(i), userValue.get(i));
        }
    }

    public void addCardsForDealer(ArrayList<String> dealerSuit, ArrayList<String> dealerValue)
    {
        for (int i = 0; i < dealerSuit.size(); i++)
        {
            addDealerCard(dealerSuit.get(i), dealerValue.get(i));
        }
    }

    public double returnPercentage()
    {
        return player.calculateOddsWithDealerFaceDown(this);
    }

    public double returnBlackjackPercentage()
    {
        return player.calculateOddsOfBlackJack(this);
    }

    private void addPlayerCard(String suit, String value)
    {
        player.addToHand(deck.remove(suit.toLowerCase(), value.toLowerCase()));
    }
    
    private void addDealerCard(String suit, String value)
    {
        house.addToHand(deck.remove(suit.toLowerCase(), value.toLowerCase()));
    }
    
    public Deck getDeck()
    {
        return deck;
    }
    
    
}
