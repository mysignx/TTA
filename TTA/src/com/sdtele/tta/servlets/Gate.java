package com.sdtele.tta.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sdtele.tta.models.JsonRequest;
import com.sdtele.tta.models.JsonResponse;
import com.sdtele.tta.operation.*;

@WebServlet("/Gate")
public class Gate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson=new Gson();
		String jsonStr=request.getParameter("req");
		System.out.println("Gate,doPost,reqStr:"+jsonStr);
		if (jsonStr==null) return;
		
		JsonRequest jr =  gson.fromJson(jsonStr, JsonRequest.class);
		JsonResponse jres;

		Operation o;
		if ((o=getOperation(jr.getOperation()))!=null) {
			o.setRequest(request);
			jres=o.handle(jr);
		}
		else {
			jres = new JsonResponse();
			jres.setStatus(1);
			jres.setMessage("未知的操作："+jr.getOperation());
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(gson.toJson(jres));
		System.out.println("Gate,doPost,response:"+gson.toJson(jres));
	}
	
	private Operation getOperation(String jsonOperation) {
		try {
			return (Operation)Class.forName("com.sdtele.tta.operation.Operation"+jsonOperation.substring(0, 1).toUpperCase() + jsonOperation.substring(1)).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}