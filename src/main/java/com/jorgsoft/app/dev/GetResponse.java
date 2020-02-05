package com.jorgsoft.app.dev;

public class GetResponse {
	
	private String message;

	public GetResponse(String message) {
		super();
		this.message = message;
	}
	
	public GetResponse() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
