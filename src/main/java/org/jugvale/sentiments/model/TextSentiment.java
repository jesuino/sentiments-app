package org.jugvale.sentiments.model;
public class TextSentiment{
	private int id;
	private String text;
	private int polarity;

	
	/**
	 * Get id.
	 *
	 * @return id as int.
	 */
	public int getId(){
	    return id;
	}
	
	/**
	 * Set id.
	 *
	 * @param id the value to set.
	 */
	public void setId(int id){
	    this.id = id;
	}
	
	/**
	 * Get text.
	 *
	 * @return text as String.
	 */
	public String getText(){
	    return text;
	}
	
	/**
	 * Set text.
	 *
	 * @param text the value to set.
	 */
	public void setText(String text){
	    this.text = text;
	}
	
	/**
	 * Get polarity.
	 *
	 * @return polarity as int.
	 */
	public int getPolarity(){
	    return polarity;
	}
	
	/**
	 * Set polarity.
	 *
	 * @param polarity the value to set.
	 */
	public void setPolarity(int polarity){
	    this.polarity = polarity;
	}
}
