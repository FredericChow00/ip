package seedu.duke.tasks;

import seedu.duke.DukeException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private final LocalDateTime deadline;

    // for init of Deadline object from Duke.java
    public Deadline(String description, LocalDateTime deadline) {
        this(description, false, "D", deadline);
    }

    // for internal use
    public Deadline(String description, boolean isDone, String taskType, LocalDateTime deadline) {
        super(description, isDone, taskType);
        this.deadline = deadline;
    }

    public Task markTask() throws DukeException {
        if (super.isDone) {
            throw new DukeException("This task is already marked!");
        }
        return new Deadline(super.description, true, super.taskType, this.deadline);
    }

    public Task unmarkTask() throws DukeException {
        if (!super.isDone) {
            throw new DukeException("This task is already unmarked!");
        }
        return new Deadline(super.description, false, super.taskType, this.deadline);
    }

    public String formatTask() {
        return String.format("D|%b|%s|%s", this.isDone, this.description, this.deadline.toString());
    }

    @Override
    public String toString() {
        String timePattern = "d MMM yyyy, HHmm";
        return String.format("%s%s %s (by: %s)", super.getTaskTypeBox(), super.getStatusCheckbox(),
                super.toString(), this.deadline.format(DateTimeFormatter.ofPattern(timePattern)));
    }
}
