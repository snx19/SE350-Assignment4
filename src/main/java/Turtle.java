public class Turtle {
    private double x, y;
    private double direction;
    private boolean penDown;
    private DrawingStrategy strategy;
    private Matrix matrix;

    public Turtle(Matrix matrix, DrawingStrategy strategy) {
        this.matrix = matrix;
        this.strategy = strategy;
        this.x = 0;
        this.y = 0;
        this.direction = 0;
        this.penDown = false;
    }

    public void move(double distance) {
        double radians = Math.toRadians(direction);
        double newX = x + (distance * Math.cos(radians));
        double newY = y + (distance * Math.sin(radians));

        if (penDown) {
            strategy.drawLine(matrix, x, y, newX, newY);
        }
        x = newX;
        y = newY;
    }

    public void turn(double angle) {
        direction = (direction + angle) % 360;
    }

    public void setPenDown(boolean penDown) {
        this.penDown = penDown;
    }

    public Matrix getMatrix() {
        return matrix;
    }
}
