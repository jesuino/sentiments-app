package org.jugvale.sentiments.service;

import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import twitter4j.*;
import java.util.stream.Collectors;
public class SearchService{

	/*
	 *It's mine!!! Please, use yours
	 * */

	private final static String TWITTER_CONSUMER_KEY = "B4el0kjAh8CG3WEgafcGHWFt0";
	private final static String TWITTER_CONSUMER_KEY_SECRET = "vzuSoQhrHzHflKkNOXOAqbbtlS12AhI2CBO33C2cI1sKIAygRw";

	public static enum Provider{
		TWITTER("Twitter");
		
		private String name;
		Provider(String name){
			this.name = name;
		}
		public String toString(){
			return this.name;
		}
	}

	public List<String> search(String q, Provider p){
		switch (p){
			case TWITTER:
				return searchTwitter(q);
			default:
				throw new IllegalArgumentException("Provider \"" + p + "\" not implemented");
		}
	}


	/*
	
		If you want to use Twitter, remember to set auth as outlined in http://twitter4j.org/en/configuration.html
	*/
	private List<String> searchTwitter(String q){
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(TWITTER_CONSUMER_KEY, TWITTER_CONSUMER_KEY_SECRET);
		Query twitterQuery = new Query("lang:en " + q);
		try{
			return twitter.search(twitterQuery)
				.getTweets().stream()
				// map to text and replace all special chars
				.map(s -> s.getText().replaceAll("[^a-zA-Z0-9\\s\\,\\.\\']+",""))
				.peek(System.out::println)
				.collect(Collectors.toList());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}

