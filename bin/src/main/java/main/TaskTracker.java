package main;

import cli.CommandManager;

public class TaskTracker {

	public static void main(String[] args) {	
		args = new String[]{"add", "Description"};
		CommandManager commandManager = new CommandManager();
		//commandManager.handleCommand(args);
		
		args = new String[] {"update", "9f28e0ba-fb76-4de4-b35c-f6118b7fd9de", "New Description updated ·$%&/"};
		commandManager.handleCommand(args);
		
		args = new String[]{"list"};
		commandManager.handleCommand(args);
		
		
	}

}
