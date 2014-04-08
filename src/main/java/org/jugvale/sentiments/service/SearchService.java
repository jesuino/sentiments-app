package org.jugvale.sentiments.service;

import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import twitter4j.*;
import java.util.stream.Collectors;
public class SearchService{

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
		Query twitterQuery = new Query(q);
		try{
			return twitter.search(twitterQuery).getTweets().stream().map(s -> s.getText()).collect(Collectors.toList());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
