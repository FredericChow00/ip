package seedu.duke;

public class Duke {
    private final Storage storage;
    private final Ui ui;
    private final Parser parser;
    private TaskList tasks;

    private static final String[] LIST_OF_COMMANDS =
            new String[]{"list", "bye", "todo", "mark", "unmark", "event", "deadline", "delete", "find"};

    private static final String SAVE_FILE_NAME = "duke.txt";

    enum Commands {
        list, bye, todo, mark, unmark, event, deadline, delete, find
    }

    public Duke() {
        this(SAVE_FILE_NAME);
    }

    public Duke(String filePath) {
        this.ui = new Ui();
        this.parser = new Parser();
        this.storage = new Storage(filePath);
        try {
            this.tasks = storage.readFile();
        } catch (DukeException err) {
            System.out.println(ui.showLoadingError());
            this.tasks = new TaskList();
        }
    }

    /**
     *  You should have your own function to generate a response to user input.
     *  Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        try {
            String[] inputStrings = input.split(" ");
            return this.parser.executeCommand(inputStrings, LIST_OF_COMMANDS, this.tasks, this.storage, this.ui);
        } catch (DukeException err)  {
            return err.getErrorMessage();
        }
    }
}

