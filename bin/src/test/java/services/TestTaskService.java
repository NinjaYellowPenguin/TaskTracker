package services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Status;
import models.Task;
import persistence.JsonManager;

public class TestTaskService {
	
	private TaskService service;

    @BeforeEach
    public void setup() {
        service = new TaskService();
    }

    @Test
    public void testAdd() {
        Task task = new Task();
        task.setId("test-add");
        task.setDescription("Tarea para añadir");

        Task result = service.add(task);

        assertEquals(task, result);
    }
    
    @Test
    public void testAddString() {
    	String description = "Tarea para añadir";
        Task result = service.add(description);

        assertEquals(description, result.getDescription());
    }

    @Test
    public void testUpdate() {
        Task task = new Task();
        task.setId("test-update");
        task.setDescription("Descripción inicial");
        service.add(task);
        
        task.setDescription("Descripción actualizada");
        Task result = service.update(task);

        assertEquals("Descripción actualizada", result.getDescription());
        assertNotNull(result.getUpdatedAt());
    }

    @Test
    public void testDelete() {
        Task task = new Task();
        task.setId("test-delete");
        task.setDescription("Para eliminar");
        service.add(task);

        Task result = service.delete(task);

        assertEquals(task, result);
    }

    
    
    @Test
    public void testMarkInProgress() throws Exception {        
        Task task = service.add("testMarkIP");        
        Task updatedTask = service.markInProgress(task.getId());
        assertEquals(Status.IN_PROGRESS, updatedTask.getStatus());
    }

    @Test
    public void testMarkDone() throws Exception {
    	 Task task = service.add("testMArkDone");        
         Task updatedTask = service.markDone(task.getId());
         assertEquals(Status.DONE, updatedTask.getStatus());
    }

    @Test
    public void testMarkTodo() throws Exception {
    	Task task = service.add("testMArkTodo");        
        Task updatedTask = service.markTodo(task.getId());
        assertEquals(Status.TODO, updatedTask.getStatus());
    }

    @Test
    public void testFindAll() {
    	
        service.add("Task1 to test findAll");
        service.add("Task2 to test findAll");

        Set<Task> tasks = service.findAll();

        assertEquals(2, tasks.size());
    }

    @Test
    public void testFindByStatus() throws Exception {
    	
        Task task = service.add("Test Find By Status 1");
        service.markTodo(task.getId());
        
        Task task2 = service.add("Test Find By Status 2");
        service.markInProgress(task2.getId());
        
        Task task3 = service.add("Test Find By Status 3");
        service.markTodo(task3.getId()); 

        Set<Task> todoTasks = service.findByStatus(Status.TODO);
        assertEquals(2, todoTasks.size());
    }

    @AfterEach
    public void clearJsonFile() {
    	JsonManager.getInstance().clear();
    }
	

}
