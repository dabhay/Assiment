package com.bank.model;

import org.springframework.http.HttpStatus;

public class UserResponse {
	private Integer Code;
	private Object data;
	private Object desc;

	public UserResponse(Object data, Object desc) {
		super();
		this.Code = HttpStatus.OK.value();
		this.data = data;
		this.desc = desc;
	}

	public Integer getCode() {
		return HttpStatus.OK.value();
	}

	public void setCode(Integer code) {
		Code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getDesc() {
		return HttpStatus.CREATED;
	}

	public void setDesc(Object desc) {
		this.desc = desc;
	}

	public HttpStatus getStatus() {

		return HttpStatus.OK;
	}

	public UserResponse() {
	
		
	}

}
