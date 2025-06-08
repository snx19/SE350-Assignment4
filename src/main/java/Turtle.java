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

    public Memento save () {
        char[][] snapshot = new char[matrix.getRows()][matrix.getCols()];
        for (int i = 0; i < matrix.getRows(); i++) {
            System.arraycopy(matrix.getRow(i), 0, snapshot[i], 0, matrix.getCols());
        }
        return new Memento(x, y, direction, penDown, snapshot);
    }

    public void restore(Memento memento) {
        this.x = memento.x;
        this.y = memento.y;
        this.direction = memento.direction;
        this.penDown = memento.penDown;
        for (int i = 0; i < matrix.getRows(); i++) {
            System.arraycopy(memento.matrixSnapshot[i], 0, matrix.getRow(i), 0, matrix.getCols());
        }
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

    public void moveTo(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    public void setDirection(double newDirection) {
        this.direction = newDirection;
    }
}
