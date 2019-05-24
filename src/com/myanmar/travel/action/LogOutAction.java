package com.myanmar.travel.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogOutAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	private SessionMap<String, Object> sessionMap;
	
	@Override
	public void setSession(Map<String, Object> map) {
		this.sessionMap = (SessionMap<String, Object>) map;
	}
	
	public String logout() {
		if(sessionMap != null) {
			sessionMap.invalidate();
		}
		return SUCCESS;
	}
}
