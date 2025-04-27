package com.example.MediCure.payloads;

public class ResponseMsg {
private String message;
private Boolean success;
public ResponseMsg() {
	super();
	// TODO Auto-generated constructor stub
}
public ResponseMsg(String message, Boolean success) {
	super();
	this.message = message;
	this.success = success;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Boolean getSuccess() {
	return success;
}
public void setSuccess(Boolean success) {
	this.success = success;
}

}
