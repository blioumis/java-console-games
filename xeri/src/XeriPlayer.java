import java.util.ArrayList;
import java.util.Scanner;

public class XeriPlayer {

    private String name;
    private Hand hand = new Hand();

    private ArrayList<Card> collectedCards = new ArrayList<>();

    private int xeriCount = 0;
    private int points = 0;
    private int cardCountBonus = 0;

    private Scanner input;

    public XeriPlayer(String name) {

        this(name, null);
    }

    public XeriPlayer(String name, Scanner input) {

        this.name = name;
        this.input = input;
    }

    public void getCards(CardStack deck) {

        // Deal six cards to the player.
        for (int i = 0; i < 6 && !deck.isEmpty(); i++) {

            hand.addCard(deck.draw());
        }
    }

    public Card selectCard() {

        if (input == null) {

            input = new Scanner(System.in);
        }

        hand.print();

        System.out.println("Select card position:");

        int position;

        // Validate the selected card position.
        while (true) {

            if (input.hasNextInt()) {

                position = input.nextInt();

                if (position >= 0 && position < hand.size()) {

                    break;
                }

            } else {

                input.next();
            }

            System.out.println("Invalid position. Please try again:");
        }

        Card selectedCard = hand.getCard(position);

        System.out.println("Player " + name
                + " selected card: " + selectedCard);

        return selectedCard;
    }

    public Card selectComputerCard() {

        return selectComputerCard(null);
    }

    public Card selectComputerCard(Card topCard) {

        Card selectedCard = hand.selectComputerCard(topCard);

        System.out.println("Player " + name
                + " selected card: " + selectedCard);

        return selectedCard;
    }

    public void collectCards(CollectedCards cards) {

        // Check the special Jack case before the regular Xeri case.
        if (cards.isXeriWithJacks()) {

            this.xeriCount += 2;

            System.out.println("Player " + this.name
                    + " made Xeri with Jacks!");

        } else if (cards.isXeri()) {

            this.xeriCount++;

            System.out.println("Player " + this.name + " made Xeri!");
        }

        this.collectedCards.addAll(cards.getList());
    }

    public void computePoints() {

        // Reset the score to prevent duplicate point calculations.
        this.points = this.cardCountBonus;

        // Calculate points according to the original game rules.
        for (Card card : this.collectedCards) {

            if (card.isTwoClubs()) {

                this.points += 2;

            } else if (card.isTenDiamond()) {

                this.points += 2;

            } else if (card.isHighCard()) {

                this.points++;
            }
        }

        // Xeri captures are counted separately from the final score.
    }

    public void compareCardCount(XeriPlayer other) {

        this.cardCountBonus = 0;
        other.cardCountBonus = 0;

        // Award three points to the player with more collected cards.
        if (this.collectedCards.size()
                < other.collectedCards.size()) {

            other.cardCountBonus = 3;

        } else if (this.collectedCards.size()
                > other.collectedCards.size()) {

            this.cardCountBonus = 3;
        }
    }

    public int getPoints() {

        return this.points;
    }

    public int getXeriCount() {

        return this.xeriCount;
    }

    public boolean outOfCards() {

        return hand.isEmpty();
    }
}