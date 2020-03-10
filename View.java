
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * This is the main class to take inputs and show output by making object of
 * other class and calling their methods.
 *
 * @author Vishal Thumar
 */
public class View {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //scanner class to store values
        boolean a = true; //boolean for the loop
        System.out.print("How many suits?\t"); //declaring variables and storing values by asking the user
        int suits = sc.nextInt();
        System.out.println("");
        System.out.print("How many ranks?\t");
        int ranks = sc.nextInt();
        System.out.println("\n");

        DeckOfCards deck = new DeckOfCards(ranks, suits); //object of DeckOfClass

        while (a) { //while loop for asking user until user want to quit

            System.out.println(deck.toString());
            System.out.print("1 to shuffel\t2 to Deal 1 hand\t3 to Deal 100000 times\t4 to quit\t");
            int input = sc.nextInt();
            System.out.println("");

            switch (input) { //switch case statement to perform operation as user chose an option
                case 1:
                    deck.shuffle(); //calling shuffle method to shuffle cards
                    break;
                case 2:
                    System.out.print("How many cards?\t");//asking user about deal cards and storing value into the variable
                    int deal = sc.nextInt();
                    System.out.println("\n");
                    deck.deal(deal); //calling deal method to deal n cards
                    for (int i = 0; i < deal; i++) {
                        System.out.print(deck.deal(i) + "\t"); //print all the cards which are dealt
                    }
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.print("How many cards?\t"); //asking user about deal cards and storing value into the variable
                    deal = sc.nextInt();
                    System.out.println("\n");
                    deck.histogram(deal); //calling histogram method to deal n cards
                    for (int i = 0; i < deal; i++) {
                        System.out.println(i+":\t"+deck.histogram(i)); //print all the cards which are dealt
                    }
                    System.out.println("\n");
                    break;
                case 4:
                    a = false; //extit the loop
                    break;
                default:
                    System.out.println("Invalid input"); //default statement for invalid input
                    System.out.println("\n");
                    break;
            }
        }
    }

}
