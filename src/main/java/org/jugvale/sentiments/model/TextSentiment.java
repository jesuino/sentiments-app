package org.jugvale.sentiments.model;
public class TextSentiment{
	private String text;
	private int polarity;

	public TextSentiment(){super();}
	
	
	public TextSentiment(String text){
		super();
		this.text = text;
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
	public String toString(){
		return "\"" + this.text + "\":" + this.polarity;
	}
}
