public class Circle extends Shape {

    public Circle(int boundingRectangleArea) {

        super("Circle", boundingRectangleArea);
    }

    @Override
    public double computeArea() {

        return (3.14 / 4) * getBoundingRectangleArea();
    }
}