package com.appsdeveloperblog.app.ws.ui.model.response;

public enum ErrorMessages {

	MISSING_REQUIRED_FIELD("Missing required field. Please check documentation"),
	RECORD_ALREADY_EXISTS("Record already exists"), INTERNAL_SERVER_ERROR("Internal Server Error");

	private String errorMessage;

	ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
