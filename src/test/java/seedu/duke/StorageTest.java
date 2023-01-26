package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.Tasks.Deadline;
import seedu.duke.Tasks.Event;
import seedu.duke.Tasks.Todo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StorageTest {
    @Test
    public void readFile_emptyInput_emptyTaskList(){
        Storage storage = new Storage("duke.txt");
        TaskList taskList = new TaskList();
        try {
            TaskList storageTaskList = storage.readFile();
            assertEquals(taskList, storageTaskList);
        } catch (DukeException err) {
            fail();
        }
    }

    @Test
    public void writeAndReadFile_threeInputs_taskListWithThreeTasks(){
        Storage storage = new Storage("duke.txt");
        TaskList taskList = new TaskList();
        try {
            LocalDate date = LocalDate.of(2023, 1, 23);
            LocalTime time = LocalTime.of(16,30);
            taskList = taskList.addTask(new Todo("borrow book"));
            taskList = taskList.addTask(new Deadline("borrow book", LocalDateTime.of(date, time)));
            taskList = taskList.addTask(new Event("borrow book",
                    LocalDateTime.of(date, time), LocalDateTime.of(date, time)));
            storage.writeFile(taskList);
            assertEquals(taskList, storage.readFile());
        } catch (DukeException err) {
            fail();
        }
    }
}