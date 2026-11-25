public abstract class Shape {

    private String shapeType;
    private int boundingRectangleArea;

    public Shape(String shapeType, int boundingRectangleArea) {

        if (boundingRectangleArea <= 0) {

            throw new IllegalArgumentException(
                    "Bounding rectangle area must be positive");
        }

        this.shapeType = shapeType;
        this.boundingRectangleArea = boundingRectangleArea;
    }

    // Each subclass implements its own area calculation.
    public abstract double computeArea();

    public double computePoints() {

        return computeArea();
    }

    public boolean sameArea(Shape other) {

        return other != null
                && this.computeArea() == other.computeArea();
    }

    public boolean sameType(Shape other) {

        return other != null
                && this.shapeType.equals(other.shapeType);
    }

    @Override
    public String toString() {

        return this.shapeType + ":" + this.computeArea();
    }

    public int getBoundingRectangleArea() {

        return this.boundingRectangleArea;
    }
}