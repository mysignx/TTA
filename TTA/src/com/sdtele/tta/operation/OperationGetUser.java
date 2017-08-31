package com.sdtele.tta.operation;

import com.sdtele.tta.models.JsonRequest;
import com.sdtele.tta.models.JsonResponse;

/**
 * 操作类实现：GetUser(json.operation=getUser)
 * @author XCream
 *说明
 *8.31
 *9.01
 */
public class OperationGetUser extends Operation {

	@Override
	public JsonResponse handle(JsonRequest jsonRequest) {
		JsonResponse jr = new JsonResponse();
		jr.setStatus(0);
		jr.setEntity(request.getSession().getAttribute("user"));
		return jr;
	}

}
