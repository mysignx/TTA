package com.sdtele.tta.operation;

import javax.servlet.http.HttpServletRequest;

import com.sdtele.tta.models.JsonRequest;
import com.sdtele.tta.models.JsonResponse;

/**
 * 代表一项操作的抽象类
 * @author XCream
 *
 */
public abstract class Operation {
	/**
	 * 常数OP_LOGIN表示登录操作，值为"login"
	 */
	public static final String OP_LOGIN="login";
	/**
	 * 常数OP_LOGOUT表示登出操作，值为"logout"
	 */
	public static final String OP_LOGOUT="logout";
	/**
	 * 常数OP_GET_CONTACT表示获取通讯录操作，值为"getContact"
	 */
	public static final String OP_GET_CONTACT="getContact";
	/**
	 * 常数OP_ADD_USER表示添加用户操作，值为"addUser"
	 */
	public static final String OP_ADD_USER="addUser";
	
	protected HttpServletRequest request;
	
	/**
	 * 向Operation传递当前的HttpServletRequest对象
	 * @param request
	 * 		一般为当前servlet的request对象。
	 */
	public void setRequest(HttpServletRequest request) {
		this.request=request;
	}
	
	public Operation() {}
	public Operation(HttpServletRequest request) {
		setRequest(request);
	}
	
	/**
	 * Operation类的主要处理方法，用以处理json格式的请求
	 * @param jsonRequest
	 * 		本次Web请求的JsonRequest对象
	 * 		@see JsonRequest
	 * @return
	 * 		返回JsonResponse。
	 * 		@see JsonResponse
	 */
	public abstract JsonResponse handle(JsonRequest jsonRequest);
}
