package cli;


import java.util.Set;

import models.Status;
import models.Task;
import services.TaskService;

public class CommandManager {
	
	private TaskService taskService;
	
	public CommandManager() {
		taskService = new TaskService();
	}
	
	public void handleCommand(String[] args) {
		
		if (args.length == 0) {
	        System.out.println("Missing args.");
	        return;
	    }
		
		String command = args[0].toLowerCase();

	    switch (command) {
	        case "add":
	            handleAdd(args);
	            break;
	        case "list":
	            handleList(args);
	            break;
	        case "update":
	            handleUpdate(args);
	            break;
	        case "delete":
	            handleDelete(args);
	            break;
	        case "mark-in-progress":
	        	handleMarkInProgress(args);
	        	break;
	        case "mark-done":
	        	handleMarkDone(args);
	        	break;
	        case "mark-todo":
	        	handleMarkTodo(args);
	        	break;
	        default:
	            System.out.println("Unknown command: " + command);
	            break;
	    }
	}
	
	private void handleMarkInProgress(String[] args) {
		if (args.length != 2) {
	        System.out.println("Missing id. Usage: task-cli mark-in-progress \"Id\"");
	        return;
	    }
		String id = args[1];
		try {
			taskService.markInProgress(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	private void handleMarkDone(String[] args) {
		if (args.length != 2) {
	        System.out.println("Missing id. Usage: task-cli mark-done \"Id\"");
	        return;
	    }
		String id = args[1];
		try {
			taskService.markDone(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	private void handleMarkTodo(String[] args) {
		if (args.length != 2) {
	        System.out.println("Missing id. Usage: task-cli mark-todo \"Id\"");
	        return;
	    }
		String id = args[1];
		try {
			taskService.markTodo(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}

	private void handleUpdate(String[] args){
		if (args.length != 3) {
	        System.out.println("Missing description. Usage: task-cli update \"Id\" \"New Task Description\"");
	        return;
	    }
		String id = args[1].trim();
		String newDescription = args[2].trim();
		try {
			taskService.update(id, newDescription);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private void handleDelete(String[] args) {
		if (args.length != 2) {
	        System.out.println("Missing task description. Usage: task-cli delete \"Id\"");
	        return;
	    }
		
		String idToDelete = args[1].trim();	
	    Task result = taskService.delete(idToDelete);
	    System.out.println("Task deleted successfully(ID: " + result.getId() + ")");
		
	}

	private void handleList(String[] args) {
		if(args.length == 1) {
			Set<Task> tasks = taskService.findAll();
			tasks.forEach(System.out::println);
		}
		if(args.length > 1) {
			switch(args[1]) {
			case("done"):
				taskService.findByStatus(Status.DONE);
				break;
			case("todo"):
				taskService.findByStatus(Status.TODO);
				break;
			case("in-progress"):
				taskService.findByStatus(Status.IN_PROGRESS);
				break;
			}
		}
	}

	private void handleAdd(String[] args) {
		
		if (args.length < 2) {
	        System.out.println("Missing task description. Usage: task-cli add \"Buy groceries\"");
	        return;
	    }
		
	    String description = args[1].trim();
	    description = description.replaceAll("^\"|\"$", "");	
	    Task result = taskService.add(description);
	    System.out.println("Task added successfully (ID: " + result.getId() + ")");
	}



}
