public class BetweenDealer {

    private CardStack stack;
    private int dealerCoins;

    public BetweenDealer(int pot) {

        this.dealerCoins = pot;
        this.stack = new CardStack(6);

        stack.shuffle();
    }

    public boolean emptyPot() {

        return this.dealerCoins <= 0;
    }

    public void play(BetweenPlayer player) {

        // Replace the stack when fewer than half of the cards remain.
        if (stack.isHalfEmpty()) {

            stack = new CardStack(6);
            stack.shuffle();
        }

        BetweenTable table = new BetweenTable(stack);

        table.drawTableCards();

        // Equal or consecutive cards result in an automatic loss.
        if (table.defaultPlayerLoss()) {

            player.substractMoney(1);
            this.dealerCoins++;

            System.out.println("Default loss of player");

        } else {

            int playerBid = player.bid(this.dealerCoins);

            table.drawPlayerCard();

            if (table.betweenCard()) {

                player.addMoney(playerBid);
                this.dealerCoins -= playerBid;

                System.out.println("Player wins: " + playerBid);

            } else {

                player.substractMoney(playerBid);
                this.dealerCoins += playerBid;

                System.out.println("Player loses: " + playerBid);
            }
        }

        System.out.println();
    }
}