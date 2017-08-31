package com.sdtele.tta.operation;

import com.sdtele.tta.models.JsonRequest;
import com.sdtele.tta.models.JsonResponse;

/**
 * 操作类实现：Logout(json.operation=logout)
 * @author XCream
 *
 */
public class OperationLogout extends Operation {

	@Override
	public JsonResponse handle(JsonRequest jsonRequest) {
		request.getSession().removeAttribute("user");
		JsonResponse jr = new JsonResponse();
		jr.setStatus(0);
		jr.setEntity(null);
		return jr;
	}

}
