import java.util.Scanner;

public class BetweenPlayer {

    private int playerCoins;
    private Scanner input;

    public BetweenPlayer(int coins) {

        this(coins, new Scanner(System.in));
    }

    public BetweenPlayer(int coins, Scanner input) {

        this.playerCoins = coins;
        this.input = input;
    }

    public int bid(int pot) {

        System.out.println("Current pot: " + pot);
        System.out.println("Current player coins: " + this.playerCoins);
        System.out.println("Enter the number of coins you want to bid:");

        while (true) {

            if (input.hasNextInt()) {

                int bidCoins = input.nextInt();

                // A valid bid cannot exceed either available balance.
                if (bidCoins > 0
                        && bidCoins <= pot
                        && bidCoins <= this.playerCoins) {

                    return bidCoins;
                }

            } else {
                input.next();
            }

            System.out.println("Invalid bid. Please enter a valid amount:");
        }
    }

    public void addMoney(int money) {

        this.playerCoins += money;
    }

    public void substractMoney(int money) {

        this.playerCoins -= money;
    }

    public boolean isBroke() {

        return this.playerCoins <= 0;
    }
}