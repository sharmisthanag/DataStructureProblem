

public class StatusResponse{
	int statusCode;
	String status;
	String statusMessage;
	Object obj;
	StatusResponse(int statusCode,String status,String statusMessage,Object obj){
		this.statusCode=statusCode;
		this.status=status;
		this.statusMessage=statusMessage;
		this.obj=obj;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
