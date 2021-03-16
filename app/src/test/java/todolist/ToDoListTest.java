package todolist;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Test void addTaskIncreasesListSizeByOne() {
        ToDoList tasks = new ToDoList();
        int initialTasksNumber = tasks.getSize();
        tasks.addTask("Task 1", "SDA",  LocalDate.parse("2021-03-10", formatter));
        assertEquals(initialTasksNumber+1, tasks.getSize());
    }

    @Test void removeTaskByIndexDecreasesListSizeByOne() {
        ToDoList tasks = new ToDoList();
        tasks.addTask("Task 1", "SDA", LocalDate.parse("2021-03-10", formatter));
        tasks.addTask("Task 2", "SDA", LocalDate.parse("2021-03-10", formatter));
        tasks.addTask("Task 3", "SDA", LocalDate.parse("2021-03-10", formatter));

        int tasksNumberBeforeRemoving = tasks.getSize();

        tasks.removeTask(tasks.getSize() - 1);

        assertEquals(tasksNumberBeforeRemoving - 1, tasks.getSize());
    }

    @Test void removeTaskByTitleDecreasesListSizeByOne() {
        ToDoList tasks = new ToDoList();
        tasks.addTask("Task 1", "SDA", LocalDate.parse("2021-03-10", formatter));
        tasks.addTask("Task 2", "SDA", LocalDate.parse("2021-03-10", formatter));
        tasks.addTask("Task 3", "SDA", LocalDate.parse("2021-03-10", formatter));

        int tasksNumberBeforeRemoving = tasks.getSize();

        tasks.removeTaskByTitle("Task 2");

        assertEquals(tasksNumberBeforeRemoving - 1, tasks.getSize());
    }
}
