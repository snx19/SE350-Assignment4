public class NaiveStrategy implements DrawingStrategy {
    @Override
    public void drawLine(Matrix m, double x0, double y0, double x1, double y1) {
        int steps = (int)Math.max(Math.abs(x1 - x0), Math.abs(y1 - y0));
        double dx = (x1 - x0) / steps;
        double dy = (y1 - y0) / steps;
        double x = x0;
        double y = y0;
        for (int i = 0; i <= steps; i++) {
            m.setCell((int)x, (int)y, '#');
            x += dx;
            y += dy;
        }
    }
}
