package todolist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ToDoListTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Test void addTaskIncreasesListSizeByOne() {
        ToDoList tasks = new ToDoList();
        int initialTasksNumber = tasks.getSize();
        tasks.addTask("Task 1", "SDA",  LocalDate.parse("2021-03-15", formatter));
        assertEquals(initialTasksNumber+1, tasks.getSize());
    }

    @Test void removeTaskByIndexDecreasesListSizeByOne() {
        ToDoList tasks = new ToDoList();
        tasks.addTask("Task 1", "SDA", LocalDate.parse("2021-03-16", formatter));
        tasks.addTask("Task 2", "SDA", LocalDate.parse("2021-03-17", formatter));
        tasks.addTask("Task 3", "SDA", LocalDate.parse("2021-03-16", formatter));

        int tasksNumberBeforeRemoving = tasks.getSize();

        tasks.removeTask(tasks.getSize() - 1);

        assertEquals(tasksNumberBeforeRemoving - 1, tasks.getSize());
    }

    @Test void removeTaskByTitleDecreasesListSizeByOne() {
        ToDoList tasks = new ToDoList();
        tasks.addTask("Task 1", "SDA", LocalDate.parse("2021-03-16", formatter));
        tasks.addTask("Task 2", "SDA", LocalDate.parse("2021-03-16", formatter));
        tasks.addTask("Task 3", "SDA", LocalDate.parse("2021-03-16", formatter));

        int tasksNumberBeforeRemoving = tasks.getSize();

        tasks.removeTaskByTitle("Task 2");

        assertEquals(tasksNumberBeforeRemoving - 1, tasks.getSize());
    }

    @Test void getNumberOfCompletedTasks() {
        ToDoList tasks = new ToDoList();
        tasks.addTask("Task 1", "SDA", LocalDate.parse("2021-03-16", formatter));
        tasks.addTask("Task 2", "SDA", LocalDate.parse("2021-03-16", formatter));
        tasks.addTask("Task 3", "SDA", LocalDate.parse("2021-03-16", formatter));

        long tasksCompletedBefore = tasks.getCompletedCount();
        tasks.getTask(0).setCompleted();
        long tasksCompletedAfter = tasks.getCompletedCount();

        assertEquals(tasksCompletedAfter, tasks.getCompletedCount());
    }

    @Test void sortByProject() {
        ToDoList tasks = new ToDoList();
        tasks.addTask("Task 1", "SDA", LocalDate.parse("2021-03-16", formatter));
        tasks.addTask("Task 2", "Project", LocalDate.parse("2021-03-16", formatter));
        tasks.addTask("Task 3", "SDA", LocalDate.parse("2021-03-16", formatter));

       tasks.sortByProject();
       String firstAfterSorting = tasks.getTask(0).getProject();

        assertEquals("Project", tasks.getTask(0).getProject());
    }

    @Test void sortByDate() {
        ToDoList tasks = new ToDoList();
        tasks.addTask("Task 1", "SDA", LocalDate.parse("2021-03-19", formatter));
        tasks.addTask("Task 2", "Project", LocalDate.parse("2021-03-16", formatter));
        tasks.addTask("Task 3", "SDA", LocalDate.parse("2021-03-21", formatter));

        tasks.sortByDate();
        String firstAfterSorting = "Task 2";

        assertEquals(firstAfterSorting, tasks.getTask(0).getTitle());
    }
}
