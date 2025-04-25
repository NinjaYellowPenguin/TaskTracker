package services;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import dao.TaskDao;
import dao.TaskDaoJson;
import models.Status;
import models.Task;

public class TaskService {
	
	private TaskDao dao;
	
	public TaskService() {
		dao = new TaskDaoJson();
	}
	
	// task-cli add "Buy groceries"
	public Task add(String description) {
		Task task = new Task();
		task.setId(UUID.randomUUID().toString());
		task.setDescription(description);
		return add(task);
	}
	public Task add(Task task) {
		task.setCreatedAt(LocalDateTime.now());
		if(task.getStatus() == null) {
			task.setStatus(Status.TODO);
		}
		return dao.add(task);		
	}
	
	//task-cli update 1 "Buy groceries and cook dinner"
	public Task update(String id, String description) throws Exception {
		Task task = findById(id);
		task.setDescription(description);
		return update(task);
	}
	public Task update(Task task) {
		task.setUpdatedAt(LocalDateTime.now());
		return dao.update(task);		
	}

	//task-cli delete 1
	public Task delete(String id) {
		Task taskToDelete = new Task();
		taskToDelete.setId(id);
		return delete(taskToDelete);
	}
	public Task delete(Task task) {
		return dao.delete(task);		
	}
	
	//task-cli mark-in-progress 1
	
	private Task markStatus(String id, Status status) throws Exception {		
		Task task = findById(id);		
		task.setStatus(status);
		return update(task);		
	}
	
	public Task markInProgress(String id) throws Exception {
		return markStatus(id, Status.IN_PROGRESS);
	}
	public Task markDone(String id) throws Exception {
		return markStatus(id, Status.DONE);
	}
	public Task markTodo(String id) throws Exception {
		return markStatus(id, Status.TODO);
	}
	
	//task-cli list
	public Set<Task> findAll(){
		return dao.findAll();
	}
	
	//task-cli list status
	public Set<Task> findByStatus(Status status){
		return findAll().stream().filter(t -> {
			if(t.getStatus().equals(status)) {
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toSet());
	}
	
	private Task findById(String id) throws Exception {
		Task task = dao.findById(id);
		if(task == null) {
			throw new Exception("Task doesent exist with ID: " + id);
		}
		return task;
	}
	
	//task-cli mark-done 1


}
