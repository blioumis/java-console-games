public class BonusCircle extends Circle {

    private int bonus;

    public BonusCircle(int boundingRectangleArea, int bonus) {

        super(boundingRectangleArea);

        this.bonus = bonus;
    }

    // Add the bonus to the regular circle points.
    @Override
    public double computePoints() {

        return super.computePoints() + this.bonus;
    }

    @Override
    public String toString() {

        return super.toString() + " (Bonus: " + this.bonus + ")";
    }
}