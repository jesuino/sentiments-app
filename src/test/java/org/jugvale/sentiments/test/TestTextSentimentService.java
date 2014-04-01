package org.jugvale.sentiments.test;

import org.junit.Test;
import org.jugvale.sentiments.service.TextSentimentService;
import java.util.Arrays;

public class TestTextSentimentService{


	@Test
	public void testTextSentimentService(){
		TextSentimentService s = new TextSentimentService();
		s.getSentiments(Arrays.asList("obama is awesome", "obama sucks", "obama is eating a potato"));

	}

}
