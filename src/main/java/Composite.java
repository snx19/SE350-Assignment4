import java.util.ArrayList;
import java.util.List;

public class Composite implements Command {
    private List<Command> commands = new ArrayList<>();

    public void add(Command command) {
        commands.add(command);
    }
    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

}
