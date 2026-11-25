import java.util.ArrayList;

public class CollectedCards {

    private ArrayList<Card> cardsTakenFromTable;

    public CollectedCards() {

        this.cardsTakenFromTable = new ArrayList<>();
    }

    public CollectedCards(ArrayList<Card> cards) {

        this.cardsTakenFromTable = new ArrayList<>(cards);
    }

    public boolean isEmpty() {

        return this.cardsTakenFromTable.isEmpty();
    }

    public boolean isXeri() {

        // A Xeri consists of two cards with matching ranks.
        return this.cardsTakenFromTable.size() == 2
                && this.cardsTakenFromTable.get(0)
                .equals(this.cardsTakenFromTable.get(1));
    }

    public boolean isXeriWithJacks() {

        // Detect the special case of two Jacks.
        return this.cardsTakenFromTable.size() == 2
                && this.cardsTakenFromTable.get(0).isJack()
                && this.cardsTakenFromTable.get(1).isJack();
    }

    public ArrayList<Card> getList() {

        // Return a copy to protect the internal collection.
        return new ArrayList<>(this.cardsTakenFromTable);
    }
}