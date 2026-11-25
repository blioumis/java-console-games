public class ShapeGeneratorMain {

    public static void main(String[] args) {

        ShapeGenerator generator = new ShapeGenerator(2);

        // Display and retrieve all generated shapes.
        while (generator.hasShape()) {

            System.out.println(generator.toString());

            System.out.println("Next Shape: "
                    + generator.nextShape());

            System.out.println();
        }
    }
}