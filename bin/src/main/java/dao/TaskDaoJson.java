package dao;

import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import models.Task;
import persistence.JsonManager;

public class TaskDaoJson implements TaskDao{
	
	private JsonManager jsonManager;
	private Set<Task> tasks;
	private ObjectMapper mapper;
	
	public TaskDaoJson() {
		jsonManager = JsonManager.getInstance();
		this.mapper = new ObjectMapper();
		this.mapper.registerModule(new JavaTimeModule());
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
        try {
            return mapper.readValue(json, new TypeReference<Set<Task>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Set.of();
        }
    }
	
	private String toJson(Set<Task> tasks2) {
        
        try {
            return mapper.writeValueAsString(tasks2);
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
    }

	@Override
	public Task findById(String id) {
		for(Task t: tasks) {
			if(t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}

	@Override
	public Set<Task> findAll() {
		return tasks;
	}

}
