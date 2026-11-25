public class Square extends Shape {

    public Square(int boundingRectangleArea) {

        super("Square", boundingRectangleArea);
    }

    @Override
    public double computeArea() {

        return getBoundingRectangleArea();
    }
}