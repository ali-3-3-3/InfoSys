
import java.util.*;
class Card {
    
    private final int buyValue;
    private final int sellValue;

    public Card (int cardNo, int buyValue, int sellValue) {
        this.buyValue = buyValue;
        this.sellValue = sellValue;
    }

    public int getBuyValue(){
        return this.buyValue;
    }

    public int getSellValue(){
        return this.sellValue;
    }
}

class CardComparator implements Comparator<Card>{

    @Override
    public int compare(Card a, Card b) {

        int CostOfa = a.getBuyValue() + a.getSellValue();
        int CostOfb = b.getBuyValue() + b.getSellValue();

        if (CostOfa < CostOfb) {
            return -1;

        } else if (CostOfa > CostOfb) {
            return 1;

        } else {
            if (a.getBuyValue() < b.getBuyValue()) {
                return -1;

            } else if (a.getBuyValue() > b.getBuyValue()) {
                return 1;

            } else {
                return 0;

            }
        }
    }
}