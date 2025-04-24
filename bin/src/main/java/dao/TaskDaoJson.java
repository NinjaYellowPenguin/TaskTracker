package dao;

import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Task;
import persistence.JsonManager;

public class TaskDaoJson implements TaskDao{
	
	private JsonManager jsonManager;
	private Set<Task> tasks;
	
	public TaskDaoJson() {
		jsonManager = JsonManager.getInstance();
		refresh();
	}
	
	public Task add(Task task) {
		if (tasks.add(task)) {
            save();
        }
        return task;
		
	}
	public Task update(Task task) {
		tasks.remove(task);
		tasks.add(task);
		save();
		return task;
		
	}
	public Task delete(Task task) {
		tasks.remove(task);
		save();
		return task;
		
	}
	
	private void save() {
		jsonManager.write(toJson(tasks));
		refresh();
	}
	
	private void refresh() {
		String jsonString = jsonManager.readOrCreate();
		tasks = parseTasks(jsonString);
		
	}
	
	private Set<Task> parseTasks(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, new TypeReference<Set<Task>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Set.of();
        }
    }
	
	private String toJson(Set<Task> tasks2) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(tasks2);
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
    }

}
