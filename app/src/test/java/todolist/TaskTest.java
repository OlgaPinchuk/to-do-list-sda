package todolist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Test
    void getTaskTitle() {
        Task test = new Task("Test task 1", "Test app", LocalDate.parse("2021-03-15", formatter) );
        assertEquals("Test task 1", test.getTitle());
    }

    @Test
    void setTaskTitle() {
        Task test = new Task("Test task 1", "Test app", LocalDate.parse("2021-03-15", formatter) );
        test.setTitle("New title");
        assertEquals("New title", test.getTitle());
    }

    @Test
    void getTaskProjectName() {
        Task test = new Task("Test task 1", "Test app", LocalDate.parse("2021-03-15", formatter) );
        assertEquals("Test app", test.getProject());
    }

    @Test
    void setTaskProjectName() {
        Task test = new Task("Test task 1", "Test app", LocalDate.parse("2021-03-15", formatter) );
        test.setProject("Even more test app");
        assertEquals("Even more test app", test.getProject());
    }

    @Test
    void getNewTaskCompletedProperty() {
        Task test = new Task("Test task 1", "Test app", LocalDate.parse("2021-03-15", formatter) );
        assertFalse(test.isCompleted());
    }

    @Test
    void setTaskCompleted() {
        Task test = new Task("Test task 1", "Test app", LocalDate.parse("2021-03-15", formatter) );
        test.setCompleted();
        assertTrue(test.isCompleted());
    }

    @Test
    void getDueDate() {
        Task test = new Task("Test task 1", "Test app", LocalDate.parse("2021-03-15", formatter) );
        assertEquals(LocalDate.parse("2021-03-15", formatter), test.getDueDate());
    }

    @Test
    void setDueDate() {
        Task test = new Task("Test task 1", "Test app", LocalDate.parse("2021-03-15", formatter) );
        test.setDueDate("2021-03-18");
        assertEquals(LocalDate.parse("2021-03-18", formatter), test.getDueDate());
    }

}
