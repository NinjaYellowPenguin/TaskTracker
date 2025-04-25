package main;

import cli.CommandManager;
import persistence.JsonManager;

public class Main {

	public static void main(String[] args) {	
		args = new String[]{"add", "Description"};
		CommandManager commandManager = new CommandManager();
		commandManager.handleCommand(args);
		
		System.out.println(JsonManager.getInstance().readOrCreate());
		JsonManager.getInstance().clear();
		
	}

}
