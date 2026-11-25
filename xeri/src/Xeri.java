import java.util.Scanner;

public class Xeri {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        XeriPlayer human = new XeriPlayer("Human", input);
        XeriPlayer computer = new XeriPlayer("Computer");

        CardStack deck = new CardStack();

        deck.shuffle();

        Pile pile = new Pile();

        // Place four random cards on the table.
        pile.fill(deck);

        System.out.println(pile.toString());

        // Deal and play all four rounds.
        while (!deck.isEmpty()) {

            human.getCards(deck);
            computer.getCards(deck);

            while (!human.outOfCards() && !computer.outOfCards()) {

                System.out.println("Player Human turn");

                pile.printTopCard();

                Card humanCard = human.selectCard();

                human.collectCards(pile.drop(humanCard));

                System.out.println();

                System.out.println("Player Computer turn");

                pile.printTopCard();

                Card computerCard =
                        computer.selectComputerCard(pile.gettopCard());

                computer.collectCards(pile.drop(computerCard));

                System.out.println();
            }
        }

        // Remaining table cards are not awarded to either player.

        human.compareCardCount(computer);

        human.computePoints();
        computer.computePoints();

        System.out.println("----- FINAL RESULTS -----");

        System.out.println("Human Xeri counter: "
                + human.getXeriCount());

        System.out.println("Computer Xeri counter: "
                + computer.getXeriCount());

        System.out.println();

        System.out.println("Human points: " + human.getPoints());
        System.out.println("Computer points: " + computer.getPoints());

        System.out.println();

        if (human.getPoints() > computer.getPoints()) {

            System.out.println("Human won!");

        } else if (human.getPoints() < computer.getPoints()) {

            System.out.println("Computer won!");

        } else {

            System.out.println("It's a tie!");
        }

        input.close();
    }
}