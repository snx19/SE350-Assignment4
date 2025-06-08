import java.util.Scanner;
import java.util.Stack;

public class REPL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Turtle turtle = new Turtle(new Matrix(10, 20), new BresenhamStrategy());
        Stack<Memento> undoStack = new Stack<>();
        Stack<Memento> redoStack = new Stack<>();

        while (true) {
            System.out.print("> ");
            String[] tokens = scanner.nextLine().trim().split("\\s+");
            if (tokens.length == 0 || tokens[0].isEmpty()) {
                continue;
            }
            String cmd = tokens[0].toLowerCase();
            if (cmd.equals("quit")) {
                break;
            }

            try {
                switch (cmd) {
                    case "move", "trace", "turn" -> {
                        undoStack.push(turtle.save());
                        redoStack.push(turtle.save());
                        double val = Double.parseDouble(tokens[1]);
                        switch (cmd) {
                            case "move" -> new MoveCommand(turtle, Double.parseDouble(tokens[1])).execute();
                            case "trace" -> new TraceCommand(turtle, Double.parseDouble(tokens[1])).execute();
                            case "turn" -> new TurnCommand(turtle, Double.parseDouble(tokens[1])).execute();
                        }
                    }
                    case "show" -> new ShowCommand(turtle).execute();

                    case "undo" -> {
                        if (!undoStack.isEmpty()) {
                            redoStack.push(turtle.save());
                            turtle.restore(undoStack.pop());
                        } else{
                            System.out.println("Nothing to undo");
                        }
                    }
                    case "redo" -> {
                        if (!redoStack.isEmpty()) {
                            undoStack.push(turtle.save());
                            turtle.restore(redoStack.pop());
                        } else {
                            System.out.println("Nothing to redo");
                        }
                    }
                    default -> System.out.println("Unknown command");
                }
            }
            catch (Exception e) {
                System.out.println("Error");
            }
        }
        scanner.close();
    }
}
