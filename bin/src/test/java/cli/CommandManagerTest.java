package cli;

import org.junit.jupiter.api.*;

import persistence.JsonManager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommandManagerTest {

    private CommandManager commandManager;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private String taskId;

    @BeforeAll
    void setUp() {
        commandManager = new CommandManager();
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    void tearDown() {
        System.setOut(originalOut);
        JsonManager.getInstance().clear();
    }

    @Test
    @Order(1)
    void testAdd() {
        String[] args = {"add", "Task CLI Test"};
        commandManager.handleCommand(args);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Task added successfully"));
        taskId = extractIdFromOutput(output);
        assertNotNull(taskId);
        outContent.reset();
    }

    @Test
    @Order(2)
    void testList() {
        String[] args = {"list"};
        commandManager.handleCommand(args);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Task CLI Test"));
        outContent.reset();
    }

    @Test
    @Order(3)
    void testUpdate() {
        String[] args = {"update", taskId, "Updated CLI Task"};
        commandManager.handleCommand(args);
        outContent.reset();
    }

    @Test
    @Order(4)
    void testMarkInProgress() {
        String[] args = {"mark-in-progress", taskId};
        commandManager.handleCommand(args);
        outContent.reset();
    }

    @Test
    @Order(5)
    void testMarkDone() {
        String[] args = {"mark-done", taskId};
        commandManager.handleCommand(args);
        outContent.reset();
    }

    @Test
    @Order(6)
    void testMarkTodo() {
        String[] args = {"mark-todo", taskId};
        commandManager.handleCommand(args);
        outContent.reset();
    }

    @Test
    @Order(7)
    void testDelete() {
        String[] args = {"delete", taskId};
        commandManager.handleCommand(args);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Task deleted successfully"));
        outContent.reset();
    }

    private String extractIdFromOutput(String output) {
        int start = output.indexOf("ID: ") + 4;
        int end = output.indexOf(")", start);
        if (start != -1 && end != -1 && end > start) {
            return output.substring(start, end).trim();
        }
        return null;
    }
}
