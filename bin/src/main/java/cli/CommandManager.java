package cli;


import models.Task;
import services.TaskService;

public class CommandManager {
	
	private TaskService taskService;
	
	public CommandManager() {
		taskService = new TaskService();
	}
	
	public void handleCommand(String[] args) {
		
		if (args.length < 2) {
	        System.out.println("Missing task description. Usage: task-cli add \"Buy groceries\"");
	        return;
	    }
		
		String command = args[0].toLowerCase();

	    switch (command) {
	        case "add":
	            handleAdd(args);
	            break;
	        case "list":
	            //handleList();
	            break;
	        case "delete":
	            //handleDelete(args);
	            break;
	        default:
	            System.out.println("Unknown command: " + command);
	            break;
	    }
	}
	
	private void handleAdd(String[] args) {
	    String description = args[1].trim();
	    description = description.replaceAll("^\"|\"$", "");	
	    Task result = taskService.add(description);
	    System.out.println("Task added successfully (ID: " + result.getId() + ")");
	}



}
