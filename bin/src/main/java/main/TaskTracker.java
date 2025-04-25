package main;

import cli.CommandManager;

public class TaskTracker {

	public static void main(String[] args) {	
		//args = new String[]{"add", "Description"};
		CommandManager commandManager = new CommandManager();
		commandManager.handleCommand(args);
		
		
	}

}
