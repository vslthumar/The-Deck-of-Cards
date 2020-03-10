/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This class represents card informations such as it's rank,suits and value.
 *
 * @author Vishal Thumar
 */
public class Card {

    /**
     * declared private variable for rank
     */
    private int rank;

    /**
     * declared private variable for suit
     */
    private int suit;

    /**
     * declared private variable for value
     */
    private int value;

    /**
     *
     * @param rank
     * @param suit
     */
    public Card(int rank, int suit) { //constructor of card to decide rank and suit
        this.rank = rank;
        this.suit = suit;
        value = rank * suit;
    }

    /**
     *
     * @return
     */
    public String toString() { //toString method for output
        return "S" + suit + "R" + rank;
    }
}
