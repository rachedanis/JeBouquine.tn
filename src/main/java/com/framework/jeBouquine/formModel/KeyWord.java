package com.framework.jeBouquine.formModel;
import org.hibernate.validator.constraints.NotEmpty;

public class KeyWord {
//	@NotEmpty(message="enter key word!")
	String keyWord;

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	

}
