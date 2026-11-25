import java.util.ArrayList;
import java.util.Random;

public class Hand {

    private ArrayList<Card> cardsOnHand = new ArrayList<>();

    public void addCard(Card card) {

        this.cardsOnHand.add(card);
    }

    public void print() {

        for (int i = 0; i < this.cardsOnHand.size(); i++) {

            System.out.printf("%-6s", this.cardsOnHand.get(i));
        }

        System.out.println();

        for (int i = 0; i < this.cardsOnHand.size(); i++) {

            System.out.printf("%-6d", i);
        }

        System.out.println();
    }

    public Card getCard(int position) {

        return this.cardsOnHand.remove(position);
    }

    public Card selectComputerCard(Card topCard) {

        if (this.cardsOnHand.isEmpty()) {

            return null;
        }

        if (topCard != null) {

            // Prefer a card matching the rank of the top card.
            for (int i = 0; i < this.cardsOnHand.size(); i++) {

                if (topCard.equals(this.cardsOnHand.get(i))) {

                    return this.cardsOnHand.remove(i);
                }
            }

            // Otherwise, prefer a Jack.
            for (int i = 0; i < this.cardsOnHand.size(); i++) {

                if (this.cardsOnHand.get(i).isJack()) {

                    return this.cardsOnHand.remove(i);
                }
            }
        }

        // Select a random card if no preferred move is available.
        Random random = new Random();

        int position = random.nextInt(this.cardsOnHand.size());

        return this.cardsOnHand.remove(position);
    }

    public boolean isEmpty() {

        return this.cardsOnHand.isEmpty();
    }

    public int size() {

        return this.cardsOnHand.size();
    }
}