public class Event extends Task {
    private final String from;
    private final String to;

    public Event(String description, boolean isDone, String taskType, String from, String to) {
        super(description, isDone, taskType);
        this.from = from;
        this.to = to;
    }

    public Event(String description, String from, String to) {
        this(description, false, "E", from, to);
    }

    public Task markTask() throws DukeException {
        if (super.isDone) {
            throw new DukeException("This task is already marked!");
        }
        System.out.println("Nice! I've marked this task as done:");
        Task markedTask = new Event(super.description, true, super.taskType, this.from, this.to);
        System.out.println(markedTask);
        return markedTask;
    }

    public Task unmarkTask() throws DukeException {
        if (!super.isDone) {
            throw new DukeException("This task is already unmarked!");
        }
        System.out.println("Ok, I've marked this task as not done yet:");
        Task unmarkedTask = new Event(super.description, false, super.taskType, this.from, this.to);
        System.out.println(unmarkedTask);
        return unmarkedTask;
    }

    public String formatTask() {
        return String.format("D|%b|%s|%s|%s", this.isDone, this.description, this.from, this.to);
    }

    @Override
    public String toString() {
        return String.format("%s%s %s (from: %s to: %s)", super.getTaskTypeBox(), super.getStatusCheckbox(),
                super.toString(), this.from, this.to);
    }
}
