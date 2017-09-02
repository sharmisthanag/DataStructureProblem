package org.tukku.javabrains.restAPIwithJersey.messenger.beans;

public class Comment {
	private String message;
	private Long empId;
	
	public Comment(){}
	
	public Comment(Long empId,String message){
		this.empId = empId;
		this.message = message;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

}
