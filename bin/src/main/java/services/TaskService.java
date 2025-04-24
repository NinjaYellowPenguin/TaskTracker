package services;

import java.time.LocalDateTime;

import dao.TaskDao;
import dao.TaskDaoJson;
import models.Status;
import models.Task;

public class TaskService {
	
	private TaskDao dao;
	
	public TaskService() {
		dao = new TaskDaoJson();
	}
	
	public Task add(Task task) {
		task.setCreatedAt(LocalDateTime.now());
		if(task.getStatus() == null) {
			task.setStatus(Status.TODO);
		}
		return dao.add(task);		
	}
	public Task update(Task task) {
		task.setUpdatedAt(LocalDateTime.now());
		return dao.update(task);		
	}
	public Task delete(Task task) {
		return dao.delete(task);		
	}

}
