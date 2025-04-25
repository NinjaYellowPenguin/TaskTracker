package dao;

import java.util.Set;

import models.Task;

public interface TaskDao {
	
	public Task add(Task task);
	public Task update(Task task);
	public Task delete(Task task);
	
	public Task findById(String id);
	public Set<Task> findAll();

}
