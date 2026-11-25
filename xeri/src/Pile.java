import java.util.ArrayList;

public class Pile {

    private ArrayList<Card> cardsOnTable = new ArrayList<>();
    private Card topCard = null;

    public void fill(CardStack stack) {

        // Place four initial cards on the table.
        for (int i = 0; i < 4 && !stack.isEmpty(); i++) {

            this.cardsOnTable.add(stack.draw());
        }

        if (!this.cardsOnTable.isEmpty()) {

            this.topCard =
                    this.cardsOnTable.get(this.cardsOnTable.size() - 1);
        }
    }

    public CollectedCards drop(Card card) {

        ArrayList<Card> collectedCards = new ArrayList<>();

        if (this.topCard == null) {

            // Start a new pile.
            this.cardsOnTable.add(card);
            this.topCard = card;

        } else if (card.equals(this.topCard) || card.isJack()) {

            // Matching ranks or a Jack capture the entire pile.
            this.cardsOnTable.add(card);

            collectedCards.addAll(this.cardsOnTable);

            this.cardsOnTable.clear();
            this.topCard = null;

        } else {

            // Keep the played card on the table.
            this.cardsOnTable.add(card);
            this.topCard = card;
        }

        return new CollectedCards(collectedCards);
    }

    public Card gettopCard() {

        return this.topCard;
    }

    public void printTopCard() {

        if (this.topCard == null) {

            System.out.println("Top Card: -");

        } else {

            System.out.println("Top Card: " + gettopCard());
        }
    }

    @Override
    public String toString() {

        if (this.cardsOnTable.isEmpty()) {

            return "Pile Cards: -";
        }

        StringBuilder result = new StringBuilder();

        for (Card card : this.cardsOnTable) {

            result.append(card).append(" ");
        }

        return "Pile Cards: " + result;
    }
}