/**
 * @author Ali
 */

import java.io.*;
import java.util.*;

class cardtrading {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        //1st line (input): N, T, K
        int noOfCards = sc.nextInt();
        int noOfTypes = sc.nextInt();
        int noOfCombos = sc.nextInt();
        sc.nextLine();

        //2nd line (input): What cards Anthony has
        int[] cards = new int[noOfCards];

        for (int i = 0; i < noOfCards; i++) {
            int cardNo = sc.nextInt();;
            cards[cardNo]++;
        }

        sc.nextLine();

        //3rd line (input) onwards: Buy & Sell prices
        int count = 0;
        ArrayList<Card> cardValues = new ArrayList<Card>();

        while (count < noOfTypes) {
            int cardNo = count + 1;
            int buyPrice = sc.nextInt();
            int sellPrice = sc.nextInt();
            sc.nextLine();

            int buyValue = (2 - cards[cardNo]) * buyPrice;
            int sellValue = cards[cardNo] * sellPrice;

            cardValues.add(new Card(cardNo, buyValue, sellValue));
            
            count++;
        }

        Collections.sort(cardValues, new CardComparator());

        //(Output) Computation of profits
        long profit = 0;
        for (int i = 0; i < noOfCombos; i++) {
            Card card = cardValues.get(i);
            profit -= card.getBuyValue();
        }
        for (int j = noOfCombos; j < noOfTypes; j++) {
            Card card = cardValues.get(j);
            profit += card.getSellValue();
        }

        //(Output) Print
        System.out.println(profit);
        sc.close();

    }
}