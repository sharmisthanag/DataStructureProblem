package org.tukku.javabrains.restAPIwithJersey.messenger.beans;

public class Links {
	private String link;
	private String ref;
	
	public Links(){
	}
	
	public Links(String link,String ref){
		this.link = link;
		this.ref = ref;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	

}
