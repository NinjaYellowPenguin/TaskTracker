package persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class JsonManager {
	
	private static JsonManager instance;
	
	private final Path PATH = Paths.get("TaskPersistence.json");
	private final String emptyJson = "{ \"tasks\": [] }";
	
	private JsonManager() {}
	
	public String readOrCreate() {
        try {
            if (!Files.exists(PATH)) {               
                return write(emptyJson);
            }
            return Files.readString(PATH);
        } catch (IOException e) {
            e.printStackTrace();
            return emptyJson;
        }
    }

    public String write(String newJson) {
        try {
            Files.write(PATH, newJson.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newJson;
    }
    
    public static JsonManager getInstance() {
    	if(instance == null) {
    		instance = new JsonManager();
    	}
    	return instance;
    }

}
