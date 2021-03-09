package todolist;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    @Test void addTaskIncreasesListSizeByOne() {
        ToDoList tasks = new ToDoList();
        int initialTasksNumber = tasks.getTasksNumber();
        tasks.addTask("Task 1", "SDA", "2021-03-10");
        assertEquals(initialTasksNumber+1, tasks.getTasksNumber());
    }

    @Test void removeTaskByIndexDecreasesListSizeByOne() {
        ToDoList tasks = new ToDoList();
        tasks.addTask("Task 1", "SDA", "2021-03-10");
        tasks.addTask("Task 2", "SDA", "2021-03-11");
        tasks.addTask("Task 3", "SDA", "2021-03-12");

        int tasksNumberBeforeRemoving = tasks.getTasksNumber();

        tasks.removeTask(tasks.getTasksNumber() - 1);

        assertEquals(tasksNumberBeforeRemoving - 1, tasks.getTasksNumber());
    }

    @Test void removeTaskByTitleDecreasesListSizeByOne() {
        ToDoList tasks = new ToDoList();
        tasks.addTask("Task 1", "SDA", "2021-03-10");
        tasks.addTask("Task 2", "SDA", "2021-03-11");
        tasks.addTask("Task 3", "SDA", "2021-03-12");

        int tasksNumberBeforeRemoving = tasks.getTasksNumber();

        tasks.removeTaskByTitle("Task 2");

        assertEquals(tasksNumberBeforeRemoving - 1, tasks.getTasksNumber());
    }
}
