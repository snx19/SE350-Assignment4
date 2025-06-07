public class Memento {
    double x, y, direction;
    boolean penDown;
    char[][] matrixSnapshot;

    public Memento(double x, double y, double direction, boolean penDown, char[][] matrixSnapshot) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.penDown = penDown;
        this.matrixSnapshot = matrixSnapshot;
    }
}
