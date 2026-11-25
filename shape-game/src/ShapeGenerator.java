import java.util.Random;
import java.util.ArrayList;

public class ShapeGenerator {

    private Shape[] shapes;
    private int currentShapes;

    public ShapeGenerator(int numberOfShapes) {

        if (numberOfShapes <= 0) {

            throw new IllegalArgumentException(
                    "Number of shapes must be positive");
        }

        initializeShapes(numberOfShapes);
    }

    private void initializeShapes(int numberOfShapes) {

        int[] boundingAreas = {1, 2, 3, 4, 8, 12, 16};

        Random random = new Random();

        ArrayList<Shape> shapeList = new ArrayList<>();

        // Generate squares.
        for (int i = 0; i < numberOfShapes; i++) {

            int randomArea =
                    boundingAreas[random.nextInt(boundingAreas.length)];

            shapeList.add(new Square(randomArea));
        }

        // Generate triangles.
        for (int i = 0; i < numberOfShapes; i++) {

            int randomArea =
                    boundingAreas[random.nextInt(boundingAreas.length)];

            shapeList.add(new Triangle(randomArea));
        }

        // Generate pentagons.
        for (int i = 0; i < numberOfShapes; i++) {

            int randomArea =
                    boundingAreas[random.nextInt(boundingAreas.length)];

            shapeList.add(new Pentagon(randomArea));
        }

        // Generate circles.
        for (int i = 0; i < numberOfShapes; i++) {

            int randomArea =
                    boundingAreas[random.nextInt(boundingAreas.length)];

            shapeList.add(new Circle(randomArea));
        }

        // Generate bonus circles with a bonus between 1 and 10.
        for (int i = 0; i < numberOfShapes; i++) {

            int randomArea =
                    boundingAreas[random.nextInt(boundingAreas.length)];

            int bonus = random.nextInt(10) + 1;

            shapeList.add(new BonusCircle(randomArea, bonus));
        }

        this.shapes = new Shape[shapeList.size()];

        shapeList.toArray(this.shapes);

        this.currentShapes = this.shapes.length;

        // Shuffle the shapes using Fisher-Yates.
        for (int i = this.currentShapes - 1; i > 0; i--) {

            int randomIndex = random.nextInt(i + 1);

            Shape temporary = this.shapes[i];
            this.shapes[i] = this.shapes[randomIndex];
            this.shapes[randomIndex] = temporary;
        }
    }

    public Shape nextShape() {

        if (this.currentShapes == 0) {

            return null;
        }

        // Retrieve a shape without reallocating the array.
        this.currentShapes--;

        Shape nextShape = this.shapes[this.currentShapes];

        this.shapes[this.currentShapes] = null;

        return nextShape;
    }

    public boolean hasShape() {

        return this.currentShapes > 0;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.currentShapes; i++) {

            result.append(this.shapes[i]).append("\n");
        }

        return result.toString();
    }
}