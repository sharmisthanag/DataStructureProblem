
public enum SMEReviewStatus {	

	
	NOT_STARTED("Not Started"),
	REVIEW_PENDING("Review Pending"),
	REVIEW_IN_PROGRESS("Review in Progress"),
	COMPLETED("Completed");

	private String status;

	SMEReviewStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	} 

} 