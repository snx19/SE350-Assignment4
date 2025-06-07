public interface Command {
    void execute();
}


class MoveCommand implements Command {
    private Turtle turtle;
    private double distance;

    public MoveCommand(Turtle turtle, double distance) {
        this.turtle = turtle;
        this.distance = distance;
    }
    @Override
    public void execute() {
        turtle.setPenDown(false);
        turtle.move(distance);

    }
}

class TraceCommand implements Command {
    private Turtle turtle;
    private double distance;

    public TraceCommand(Turtle turtle, double distance) {
        this.turtle = turtle;
        this.distance = distance;
    }
    @Override
    public void execute() {
        turtle.setPenDown(true);
        turtle.move(distance);
    }
}

class TurnCommand implements Command {
    private Turtle turtle;
    private double angle;

    public TurnCommand(Turtle turtle, double angle) {
        this.turtle = turtle;
        this.angle = angle;
    }
    @Override
    public void execute() {
        turtle.turn(angle);
    }
}

class ShowCommand implements Command {
    private Turtle turtle;

    public ShowCommand(Turtle turtle) {
        this.turtle = turtle;
    }
    @Override
    public void execute() {
        turtle.getMatrix().print();
    }
}
