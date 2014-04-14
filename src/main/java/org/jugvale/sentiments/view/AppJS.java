package org.jugvale.sentiments.view;

import javafx.application.Application;
import javafx.stage.Stage;
import java.nio.file.*;
import javax.script.*;;
import java.net.URL;

public class AppJS extends Application{

	private final URL SCRIPT = getClass().getResource("/sentimentsView.js");

	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void start(Stage stage){
		try{
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			engine.put("stage", stage);
			String scriptContent = new String(Files.readAllBytes((Paths.get(SCRIPT.toURI()))));
			engine.eval(scriptContent);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
 }
