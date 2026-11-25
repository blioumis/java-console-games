public class Card {

    private String suit;
    private int rank;

    public Card(int rank, String suit) {

        if (rank < 2 || rank > 14) {

            throw new IllegalArgumentException("Invalid card rank");
        }

        if (!"S".equals(suit)
                && !"H".equals(suit)
                && !"D".equals(suit)
                && !"C".equals(suit)) {

            throw new IllegalArgumentException("Invalid card suit");
        }

        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {

        if (this.rank == 11) {
            return "J" + this.suit;

        } else if (this.rank == 12) {
            return "Q" + this.suit;

        } else if (this.rank == 13) {
            return "K" + this.suit;

        } else if (this.rank == 14) {
            return "A" + this.suit;
        }

        return this.rank + this.suit;
    }

    // Compare cards by rank, regardless of their suit.
    public boolean equals(Card other) {

        return other != null && this.rank == other.rank;
    }

    public boolean consecutive(Card other) {

        int difference = this.rank - other.rank;

        return difference == 1 || difference == -1;
    }

    public boolean greaterThan(Card other) {

        return this.rank > other.rank;
    }

    public boolean between(Card[] cards) {

        return this.greaterThan(cards[0])
                && this.rank < cards[1].rank;
    }
}