import java.util.Scanner;
import java.util.Locale;

public class ShapeGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Give the number of shapes per type:");

        int numberOfShapes = readPositiveInteger(input);

        System.out.println("Give the size of the stack for the player:");

        int stackSize = readPositiveInteger(input);

        System.out.println();

        ShapeGenerator generator =
                new ShapeGenerator(numberOfShapes);

        Player player = new Player(stackSize, input);

        // Continue while shapes remain and the stack is not full.
        while (generator.hasShape() && !player.isStackFull()) {

            player.printStack();

            player.playShape(generator.nextShape());

            System.out.printf(Locale.US, "Player has %.2f points%n",
                    player.getPlayerPoints());

            System.out.println();
        }

        // Display the final stack and score.
        player.printStack();

        System.out.printf(Locale.US, "Final score: %.2f%n",
                player.getPlayerPoints());

        System.out.println("GAME OVER");

        input.close();
    }

    // Read and validate a positive integer.
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