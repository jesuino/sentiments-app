package org.jugvale.sentiments.view;

import javafx.application.Application;
import javafx.stage.Stage;
import javax.script.*;;
import java.io.FileReader;

public class AppJS extends Application{

	private final String SCRIPT = getClass().getResource("/sentimentsView.js").getPath();

	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void start(Stage stage){
		try{
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			engine.put("stage", stage);
			engine.eval(new FileReader(SCRIPT));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
 }
