package org.jugvale.sentiments.test;

import org.junit.Test;
import org.jugvale.sentiments.service.*;
import org.jugvale.sentiments.model.*;
import java.util.Arrays;

public class TestService{


	@Test
	public void testServices(){
		String TXT_1 = "obama is awesome";
		String TXT_2 = "obama sucks";
		String TXT_3 = "obama is eating a potato";
		TextSentimentService s = new TextSentimentService();
		TextSentimentList list = s.getSentiments(Arrays.asList(TXT_1, TXT_2, TXT_3));
		list.getTextSentiments().stream().forEach(System.out::println);
		//TODO: Create a Map with key equal the text and polarity is the value
	}

}
