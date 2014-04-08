package org.jugvale.sentiments.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.VBox;
import javafx.scene.chart.*;
import org.jugvale.sentiments.service.*;
import org.jugvale.sentiments.model.*;
import java.util.*;

public class App extends Application{

	final TextSentimentService textSentimentService = new TextSentimentService();
	final SearchService searchService = new SearchService();
	final PieChart chart =  new PieChart();
	final TableView<TextSentiment> table = new TableView<>();
	final TextField txtQuery = new TextField();

	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void start(Stage stage){
		VBox root = new VBox(10);
		root.getChildren().addAll(txtQuery, chart, table);
		stage.setScene(new Scene(root));
		stage.setWidth(400);
		stage.setHeight(550);
		stage.setTitle("Sentiments");
		stage.show();
		txtQuery.setOnAction(e -> {
			List<TextSentiment> textSentiments = getTextSentiments(txtQuery.getText());
			fillTable(textSentiments);
			fillChart(textSentiments);
			chart.setTitle("Sentiments for \"" + txtQuery.getText() +"\"");
		});
		txtQuery.setPromptText("Enter your query for text and press enter");
		initializeApp();		
	}

	private void initializeApp(){
		txtQuery.setText(null);
		txtQuery.getOnAction().handle(null);
		addTableColumns();
	}
	
	private void addTableColumns(){
		TableColumn<TextSentiment,String> textCol = new TableColumn<>("Text");
		textCol.setCellValueFactory(new PropertyValueFactory("text"));
		textCol.setMinWidth(200);
		TableColumn<TextSentiment,String> polarityCol = new TableColumn<>("Polarity");
		polarityCol.setCellValueFactory(new PropertyValueFactory("polarity"));
		polarityCol.setMinWidth(80);
		polarityCol.setResizable(false);
		table.getColumns().setAll(textCol, polarityCol);
	}

	public void fillTable(List<TextSentiment> textSentiments){
		table.setItems(FXCollections.observableArrayList(textSentiments));
	}

	public void fillChart(List<TextSentiment> textSentiments){
		long polarity0Count = textSentiments.stream().filter(s -> s.getPolarity() == 0).count();
		long polarity2Count = textSentiments.stream().filter(s -> s.getPolarity() == 2).count();
		long polarity4Count = textSentiments.stream().filter(s -> s.getPolarity() == 4).count();
		chart.setData(
			FXCollections.observableArrayList(
				new PieChart.Data(":(", polarity0Count),
				new PieChart.Data(":|", polarity2Count),
				new PieChart.Data(":)", polarity4Count)
		));
	}
	public List<TextSentiment> getTextSentiments(String q){
		return textSentimentService.getSentiments(query(q)).getTextSentiments();
	}

	public List<String> query(String q){
		if(q == null){
			return Arrays.asList("obama is awesome", "obama sucks", "obama eats potato");
		}else{
			// TODO: add new providers and adapt the app to support it
			searchService.search(q, SearchService.Provider.TWITTER);
			return null;
		}
	}
 }
