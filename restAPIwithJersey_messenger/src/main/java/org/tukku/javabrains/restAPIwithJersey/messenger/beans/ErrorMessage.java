package org.tukku.javabrains.restAPIwithJersey.messenger.beans;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class ErrorMessage {
	
	private int errorCode;
	private String message;
	public ErrorMessage(){}
	
	public ErrorMessage(int errorCode,String message){
		this.errorCode = errorCode;
		this.message = message;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ErrorMessage [errorCode=" + errorCode + ", message=" + message + "]";
	}

}
