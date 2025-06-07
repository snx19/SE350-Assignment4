public class Pen {
    private DrawingStrategy drawingStrategy;

    public Pen(DrawingStrategy drawingStrategy) {
        this.drawingStrategy = drawingStrategy;
    }

    public void setStrategy(DrawingStrategy drawingStrategy) {
        this.drawingStrategy = drawingStrategy;
    }

    public void drawLine(Matrix m, double x0, double y0, double x1, double y1) {
        drawingStrategy.drawLine(m, x0, y0, x1, y1);
    }
}
