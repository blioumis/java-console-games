public class BetweenTable {

    private CardStack stack;
    private Card[] tableCards = new Card[2];
    private Card pulledCard;

    public BetweenTable(CardStack stack) {

        this.stack = stack;
    }

    public void drawTableCards() {

        Card card1 = stack.draw();
        Card card2 = stack.draw();

        // Store both cards in ascending rank order.
        if (card1.greaterThan(card2)) {

            tableCards[0] = card2;
            tableCards[1] = card1;

        } else {

            tableCards[0] = card1;
            tableCards[1] = card2;
        }

        System.out.println("Table cards: "
                + tableCards[0] + " " + tableCards[1]);
    }

    public boolean defaultPlayerLoss() {

        return tableCards[0] != null
                && tableCards[1] != null
                && (tableCards[0].equals(tableCards[1])
                || tableCards[0].consecutive(tableCards[1]));
    }

    public void drawPlayerCard() {

        this.pulledCard = stack.draw();

        System.out.println("Player card: " + this.pulledCard);
    }

    public boolean betweenCard() {

        // The player's card must be strictly between the table cards.
        return this.pulledCard != null
                && this.tableCards[0] != null
                && this.tableCards[1] != null
                && this.pulledCard.between(this.tableCards);
    }
}