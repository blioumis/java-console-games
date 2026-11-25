import java.util.Scanner;

public class Between {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Pot money?");
        int pot = readPositiveInteger(input);

        System.out.println("Player money?");
        int playerMoney = readPositiveInteger(input);

        BetweenDealer dealer = new BetweenDealer(pot);
        BetweenPlayer player = new BetweenPlayer(playerMoney, input);

        // Continue until the player or the dealer runs out of money.
        while (true) {

            if (player.isBroke()) {
                System.out.println("Player lost!");
                break;

            } else if (dealer.emptyPot()) {
                System.out.println("Player wins!");
                break;
            }

            dealer.play(player);
        }

        input.close();
    }

    private static int readPositiveInteger(Scanner input) {

        while (true) {

            if (input.hasNextInt()) {

                int value = input.nextInt();

                if (value > 0) {
                    return value;
                }

            } else {
                input.next();
            }

            System.out.println("Please enter a positive integer:");
        }
    }
}