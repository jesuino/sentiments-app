package org.jugvale.sentiments.model;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class TextSentimentList{
	@XmlElement(name="data")
	private List<TextSentiment> textSentiments;

	public void setTextSentiments(List<TextSentiment> textSentiments){
		this.textSentiments = textSentiments;
	}

	public List<TextSentiment> getTextSentiments(){
		return textSentiments;
	}

}
