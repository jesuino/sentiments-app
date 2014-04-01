package org.jugvale.sentiments.service;

import org.jugvale.sentiments.model.TextSentimentList;
import org.jugvale.sentiments.model.TextSentiment;
import java.util.List;
import java.util.stream.Collectors;

public class TextSentimentService{
	public TextSentimentList getSentiments(List<String> texts){
		TextSentimentList textSentimentList = new TextSentimentList();
		textSentimentList.setTextSentiments(
			texts.stream().map(TextSentiment::new).collect(Collectors.toList())
		);
		textSentimentList.getTextSentiments().stream().forEach(System.out::println);
		return null;		
	}

}
