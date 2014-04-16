// Imports
var Scene = Java.type('javafx.scene.Scene')
var VBox = Java.type('javafx.scene.layout.VBox')
var Label = Java.type('javafx.scene.control.Label')
var TextField = Java.type('javafx.scene.control.TextField')
var PieChart = Java.type('javafx.scene.chart.PieChart')
var TableView  = Java.type('javafx.scene.control.TableView')
var TableColumn  = Java.type('javafx.scene.control.TableColumn')
var PropertyValueFactory  = Java.type('javafx.scene.control.cell.PropertyValueFactory')
var SearchService  = Java.type('org.jugvale.sentiments.service.SearchService')
var TextSentimentService  = Java.type('org.jugvale.sentiments.service.TextSentimentService')
var TableView  = Java.type('javafx.scene.control.TableView')
var FXCollections = Java.type('javafx.collections.FXCollections')

// variable declaration
var root = new VBox(10)
var txtQuery = new TextField()
var table = new TableView()
var chart = new PieChart()
var textSentimentService = new TextSentimentService()
var searchService = new SearchService()

// main block
root.children.addAll(txtQuery, chart, table)
stage.scene = new Scene(root)
stage.title = "Sentiments"
stage.width = 400
stage.height = 550
stage.show()
initializeApp()
// functions 
function initializeApp(){
	txtQuery.promptText = "Enter your query for text and press enter"
	chart.title = "Sentiments for \"" + txtQuery.getText() +"\""
	txtQuery.onAction = queryAction
	addTableColumns()
	queryAction(null)
}
function queryAction(e){
	var textSentiments = getTextSentiments(txtQuery.getText());
	fillTable(textSentiments);
	fillChart(textSentiments);
}
function fillTable(textSentiments){
	table.items = FXCollections.observableList(textSentiments)
}
function fillChart(textSentiments){
	var polarity0Count = textSentiments.stream().filter(function (s) s.getPolarity() == 0).count();
	var polarity2Count = textSentiments.stream().filter(function(s)  s.getPolarity() == 2).count();
	var polarity4Count = textSentiments.stream().filter(function(s)  s.getPolarity() == 4).count();
	chart.data = 
		FXCollections.observableArrayList(
			new PieChart.Data(":(", polarity0Count),
			new PieChart.Data(":|", polarity2Count),
			new PieChart.Data(":)", polarity4Count)
	)
}
function getTextSentiments(q){
	return textSentimentService.getSentiments(query(q)).textSentiments
}
function addTableColumns(){
	var textCol = new TableColumn("Text")
	var polarityCol = new TableColumn("Polarity")
	textCol.cellValueFactory = new PropertyValueFactory("text")
	textCol.minWidth = 200
	polarityCol.cellValueFactory = new PropertyValueFactory("polarity")
	polarityCol.minWidth = 80
	polarityCol.resizable = false
	table.columns.setAll(textCol, polarityCol)
}
function query(q){
	if(!q || q.trim().isEmpty()){
		return java.util.Arrays.asList("obama is awesome", "obama sucks", "obama eats potato");
	}else{
		return 	searchService.search(q, SearchService.Provider.TWITTER);
	}
}
