/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *this cards represents a deck of card and all the information of the deck
 * and also includes shuffle,deal,toString and histogram methods.
 *
 * @author Vishal Thumar
 */
public class DeckOfCards {

    /**
     * declared private variable for the highest rank
     */
    private int highestRank;

    /**
     * declared private variable for total number of suits
     */
    private int suits;

    /**
     * declared private variable for total cards in the deck
     */
    private int totalCards;

    /**
     * declared private variable for rank of the particular card
     */
    private int cardRank,
            /**
             * declared private variable for suit of the particular card
             */
            cardSuit,
            /**
             * declared private variable for the particular card's number
             */
            cardNumber = 0;

    /**
     * declared private array to take the values of cards
     */
    private int[] cardValue;

    /**
     * declared private object of Card class as an array
     */
    private Card[] card;

    /**
     *
     * @param highestRank
     * @param suits
     */
    public DeckOfCards(int highestRank, int suits) { //constructor of the DeckOfCards with parameters for highest rank and total suits
        this.highestRank = highestRank;
        this.suits = suits;
        totalCards = highestRank * suits; //calculate total number of cards in the deck
        cardValue = new int[totalCards]; //set array size for cardValue
        card = new Card[totalCards]; ////set array size for card object

        for (cardSuit = 1; cardSuit <= suits; cardSuit++) { //for loop to set variables in the array for card and cardValue
            for (cardRank = 1; cardRank <= highestRank; cardRank++) {
                card[cardNumber] = new Card(cardRank, cardSuit);
                cardValue[cardNumber] = cardRank * cardSuit;
                cardNumber++;

            }
        }
    }

    /**
     *
     */
    public void shuffle() { //shuffle method to shuffle the deck
        int temp = 0;
        int j = 0;
        for (cardNumber = 0; cardNumber < card.length; cardNumber++) {
            j = (int) (Math.random() * totalCards); // Get a random index out of totalcards
            card[temp] = card[cardNumber]; // Swap the cards
            card[cardNumber] = card[j];
            card[j] = card[temp];
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public Card deal(int n) { //deal method to deal cards

        int deal;
        for (deal = 0, cardNumber = (totalCards - 1); cardNumber >= (totalCards - n); cardNumber--, deal++) { // for loop to decide n amount of cards for deal
            card[deal] = card[cardNumber]; //placing values to card[deal] array
        }
        return card[deal]; //return deal array

    }

    /**
     *
     * @return
     */
    public String toString() { //toString method to get output display as string
        return "Deck of Cards:" + totalCards + "\tMin:1" + "\tMax:" + highestRank + "\tTop:" + card[(totalCards - 1)];
    }

    /**
     *
     * @param n
     * @return
     */
    public int histogram(int n) { //histogram method to make a histogram of card which are dealt

        int histogram[] = new int[totalCards];
        for (int j = 0; j < totalCards; j++) { //for loop to place values in histogram array
            histogram[j] = cardValue[j];
        }

        int sum = 0;
        for (int i = 0; i < 100000; i++) { //for loop 100000 times to get histogram
            shuffle(); //call shuffle method
            deal(n); // call deal method with n parameter passing in it
            sum = 0;

            for (int j = 0; j < n; j++) { //for loop to get sum of total cards which has been dealt

                sum = sum + cardValue[j];
            }
            histogram[sum]++; //adding 1 into sum

        }
        return histogram[sum]; //return histogram array

    }

}
