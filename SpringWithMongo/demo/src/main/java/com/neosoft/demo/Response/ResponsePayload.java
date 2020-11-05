package com.neosoft.demo.Response;

public class ResponsePayload {
	public Object data;
	public String statusCode;
	public String message;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponsePayload(Object data, String statusCode, String message) {
		super();
		this.data = data;
		this.statusCode = statusCode;
		this.message = message;
	}
	public ResponsePayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponsePayload [data=" + data + ", statusCode=" + statusCode + ", message=" + message + "]";
	}
	
	
	
	

}
