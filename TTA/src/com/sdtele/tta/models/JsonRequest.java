package com.sdtele.tta.models;

import com.google.gson.JsonObject;

/**
 * JsonRequest表示来自于Web前端的JSON请求，包含请求的操作名称及JsonObject格式的请求参数列表
 * @author XCream
 *
 */
public class JsonRequest {
	
	/**
	 * 代表请求的操作名称，该名称与OperationXXX的XXX名称一致，但第一个字母不大写
	 */
	private String operation;
	
	/**
	 * 代表请求的JSONObject格式请求参数列表
	 */
	private JsonObject jsonObject;
	
	public String getOperation() {
		return operation;
	}
	
	public JsonObject getJsonObject() {
		return jsonObject;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public void setJsonObject(JsonObject obj) {
		this.jsonObject=obj;
	}

	@Override
	public String toString() {
		return "JsonRequest [operation=" + operation + ", jsonObject=" + jsonObject + "]";
	}
}
