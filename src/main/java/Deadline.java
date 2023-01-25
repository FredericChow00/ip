public class Deadline extends Task {
    private final String deadline;

    public Deadline(String description, boolean isDone, String taskType, String deadline) {
        super(description, isDone, taskType);
        this.deadline = deadline;
    }

    public Deadline(String description, String deadline) {
        this(description, false, "D", deadline);
    }

    public Task markTask() throws DukeException {
        if (super.isDone) {
            throw new DukeException("This task is already marked!");
        }
        System.out.println("Nice! I've marked this task as done:");
        Task markedTask = new Deadline(super.description, true, super.taskType, this.deadline);
        System.out.println(markedTask);
        return markedTask;
    }

    public Task unmarkTask() throws DukeException {
        if (!super.isDone) {
            throw new DukeException("This task is already unmarked!");
        }
        System.out.println("Ok, I've marked this task as not done yet:");
        Task unmarkedTask = new Deadline(super.description, false, super.taskType, this.deadline);
        System.out.println(unmarkedTask);
        return unmarkedTask;
    }

    public String formatTask() {
        return String.format("D|%b|%s|%s", this.isDone, this.description, this.deadline);
    }

    @Override
    public String toString() {
        return String.format("%s%s %s (by: %s)", super.getTaskTypeBox(), super.getStatusCheckbox(),
                super.toString(), this.deadline);
    }
}
