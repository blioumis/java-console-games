import java.util.ArrayList;
import java.util.Random;

public class CardStack {

    private Card[] cards;
    private int numberOfCardsNow;
    private int sumOfCards;

    public CardStack() {

        this(1);
    }

    public CardStack(int numberOfDecks) {

        if (numberOfDecks <= 0) {

            throw new IllegalArgumentException("Invalid number of decks");
        }

        ArrayList<Card> cardList = new ArrayList<>();
        String[] suits = {"S", "H", "D", "C"};

        // Create the requested number of standard decks.
        for (int deck = 0; deck < numberOfDecks; deck++) {

            for (String suit : suits) {

                for (int rank = 2; rank < 15; rank++) {

                    cardList.add(new Card(rank, suit));
                }
            }
        }

        cards = new Card[cardList.size()];
        cardList.toArray(cards);

        this.sumOfCards = cards.length;
        this.numberOfCardsNow = cards.length;
    }

    public void shuffle() {

        Random random = new Random();

        // Fisher-Yates shuffle.
        for (int i = this.numberOfCardsNow - 1; i > 0; i--) {

            int randomIndex = random.nextInt(i + 1);

            Card temporary = this.cards[i];
            this.cards[i] = this.cards[randomIndex];
            this.cards[randomIndex] = temporary;
        }
    }

    public Card draw() {

        if (this.numberOfCardsNow == 0) {

            return null;
        }

        // Remove the top card without reallocating the array.
        this.numberOfCardsNow--;

        Card topCard = this.cards[this.numberOfCardsNow];

        this.cards[this.numberOfCardsNow] = null;

        return topCard;
    }

    public boolean isEmpty() {

        return this.numberOfCardsNow == 0;
    }

    public boolean isHalfEmpty() {

        return this.numberOfCardsNow < this.sumOfCards / 2;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.numberOfCardsNow; i++) {

            result.append(this.cards[i]).append(" ");
        }

        return result.toString();
    }
}