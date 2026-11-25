public class Triangle extends Shape {

    public Triangle(int boundingRectangleArea) {

        super("Triangle", boundingRectangleArea);
    }

    @Override
    public double computeArea() {

        return 0.5 * getBoundingRectangleArea();
    }
}