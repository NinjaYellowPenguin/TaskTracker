package services;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import models.Task;

public class TestTaskService {
	
	private TaskService service;
	

	public TestTaskService() {
		service = new TaskService();
	}
	
	@Test
	public void testAdd() {
		
		Task task = new Task();
		
		task.setId("n2u923d23");
		task.setDescription("de prueba");
		
		Task result = service.add(task);
		
		assertEquals(task, result);
		
		
	}

}
