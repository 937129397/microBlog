package com.microblog.web.actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.microblog.web.model.JsonModel;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	protected JsonModel jsonModel;

	private String parseJson(JsonModel jsonModel) {
		Gson g = new Gson();
		return g.toJson(jsonModel);
	}

	public void printJson(JsonModel jsonModel, HttpServletResponse response)
			throws IOException {
		String json = parseJson(jsonModel);
		// TODO budong
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

	@Resource(name = "jsonModel")
	public void setJm(JsonModel jsonModel) {
		this.jsonModel = jsonModel;
	}
}
