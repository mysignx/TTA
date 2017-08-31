package com.sdtele.tta.models;

public class JsonResponse {
	private int status=1;
	private String message="";
	private Object entity=null;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getEntity() {
		return entity;
	}
	public void setEntity(Object entity) {
		this.entity = entity;
	}
	@Override
	public String toString() {
		return "JsonResponse [status=" + status + ", message=" + message + ", entity=" + entity + "]";
	}
}
