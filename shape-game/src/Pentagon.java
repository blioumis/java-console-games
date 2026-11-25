public class Pentagon extends Shape {

    public Pentagon(int boundingRectangleArea) {

        super("Pentagon", boundingRectangleArea);
    }

    @Override
    public double computeArea() {

        return 0.75 * getBoundingRectangleArea();
    }
}