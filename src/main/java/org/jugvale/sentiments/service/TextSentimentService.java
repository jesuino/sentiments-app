package org.jugvale.sentiments.service;

import org.jugvale.sentiments.model.TextSentimentList;
import org.jugvale.sentiments.model.TextSentiment;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

public class TextSentimentService{

	private final String SENTIMENTS_BASE_URL = "http://www.sentiment140.com/api/bulkClassifyJson";
	private final String MEDIA_TYPE = "application/json";

	public TextSentimentList getSentiments(List<String> texts){
		TextSentimentList requestEntity = new TextSentimentList();
		requestEntity.setTextSentiments(
			texts.stream().map(TextSentiment::new).collect(Collectors.toList())
		);
		return ClientBuilder.newClient()
				.target(SENTIMENTS_BASE_URL)
				.request(MEDIA_TYPE)
				.buildPost(Entity.entity(requestEntity, MEDIA_TYPE))
				.invoke(TextSentimentList.class);
	}

}
