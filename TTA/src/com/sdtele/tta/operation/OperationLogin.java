package com.sdtele.tta.operation;

import com.google.gson.JsonObject;
import com.sdtele.tta.models.JsonRequest;
import com.sdtele.tta.models.JsonResponse;
import com.sdtele.tta.models.User;

/**
 * 操作类实现：Login(json.operation=login)
 * @author XCream
 *
 */
public class OperationLogin extends Operation {

	@Override
	public JsonResponse handle(JsonRequest jsonRequest) {
		System.out.println("OperationLogin:req="+jsonRequest);
		JsonResponse jres = new JsonResponse();
		if (jsonRequest.getOperation().equals(Operation.OP_LOGIN)) {
			JsonObject jo =jsonRequest.getJsonObject();
			System.out.println("User:"+jo.get("username"));
			jres.setStatus(0);
			jres.setMessage("Login Success.");
			User u=new User();
			u.setUsername("someone");
			u.setNickname("大好人\\\\'");
			u.setId(1009L);
			User u1=new User();
			u1.setId(1010L);
			u1.setUsername("user2");
			u1.setNickname("小好人\"}");
			u1.setManager(u);
			jres.setEntity(u1);
			request.getSession().setAttribute("user", u1);
		}
		return jres;
	}

}
