import java.util.Scanner;

public class REPL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Turtle turtle = new Turtle(new Matrix(10, 20), new BresenhamStrategy());

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
                    case "move" -> new MoveCommand(turtle, Double.parseDouble(tokens[1])).execute();
                    case "trace" -> new TraceCommand(turtle, Double.parseDouble(tokens[1])).execute();
                    case "turn" -> new TurnCommand(turtle, Double.parseDouble(tokens[1])).execute();
                    case "show" -> new ShowCommand(turtle).execute();
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
