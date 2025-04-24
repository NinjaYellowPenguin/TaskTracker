package dao;

import models.Task;

public interface TaskDao {
	
	public Task add(Task task);
	public Task update(Task task);
	public Task delete(Task task);

}
