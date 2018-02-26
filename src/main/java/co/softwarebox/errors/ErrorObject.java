package co.softwarebox.errors;

public class ErrorObject {

	String status;
	String message;

	public ErrorObject ( Exception e) {
		this.message = e.getMessage();
		this.status = "ERROR";
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
