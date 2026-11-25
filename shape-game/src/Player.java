import java.util.Scanner;
import java.util.Locale;

public class Player {

    private Shape[] collectedShapes;
    private double playerPoints;
    private int stackCount;

    private Scanner input;

    public Player(int stackSize) {

        this(stackSize, new Scanner(System.in));
    }

    public Player(int stackSize, Scanner input) {

        if (stackSize <= 0) {

            throw new IllegalArgumentException(
                    "Stack size must be positive");
        }

        this.collectedShapes = new Shape[stackSize];

        this.playerPoints = 0;
        this.stackCount = 0;
        this.input = input;
    }

    public void playShape(Shape shape) {

        if (shape == null || isStackFull()) {

            return;
        }

        System.out.println("Incoming shape: " + shape.toString());
        System.out.println("Do you want to accept? (y/n)");

        String answer = input.next();

        // Validate the player's response.
        while (!answer.equalsIgnoreCase("y")
                && !answer.equalsIgnoreCase("n")) {

            System.out.println(
                    "Invalid answer, please enter 'y' or 'n'");

            answer = input.next();
        }

        // Add a blank line after the player's response.
        System.out.println();

        if (answer.equalsIgnoreCase("n")) {

            return;
        }

        double addedPoints = shape.computePoints();

        // Add the first shape to an empty stack.
        if (this.stackCount == 0) {

            this.collectedShapes[this.stackCount] = shape;

            this.stackCount++;

        } else {

            Shape topShape =
                    this.collectedShapes[this.stackCount - 1];

            boolean sameArea = shape.sameArea(topShape);
            boolean sameType = shape.sameType(topShape);

            // Same area and type: remove the top shape and award 10x points.
            if (sameArea && sameType) {

                this.stackCount--;

                this.collectedShapes[this.stackCount] = null;

                addedPoints *= 10;

                System.out.println("10X points!");
                System.out.println("Top shapes removed");

            // Same area only: add the shape and award 10x points.
            } else if (sameArea) {

                this.collectedShapes[this.stackCount] = shape;

                this.stackCount++;

                addedPoints *= 10;

            // Same type only: remove the top shape.
            } else if (sameType) {

                this.stackCount--;

                this.collectedShapes[this.stackCount] = null;

                System.out.println("Top shapes removed");

            } else {

                // Add the shape when no match exists.
                this.collectedShapes[this.stackCount] = shape;

                this.stackCount++;
            }
        }

        this.playerPoints += addedPoints;

        System.out.printf(Locale.US, "Added %.2f points%n",
                addedPoints);
    }

    public boolean isStackFull() {

        // Compare the number of stored shapes with the stack capacity.
        return this.stackCount == this.collectedShapes.length;
    }

    public void printStack() {

        System.out.println("Current Stack:");

        if (this.stackCount == 0) {

            System.out.println("Empty");

        } else {

            // Display the stack from top to bottom.
            for (int i = this.stackCount - 1; i >= 0; i--) {

                System.out.println("\t" + (i + 1)
                        + ": " + this.collectedShapes[i]);
            }
        }

        System.out.println();
    }

    public double getPlayerPoints() {

        return this.playerPoints;
    }
}