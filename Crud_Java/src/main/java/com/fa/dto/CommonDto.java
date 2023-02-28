package com.fa.dto;

import java.util.List;

public class CommonDto {
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Object getResponseObject() {
		return responseObject;
	}
	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}
	public List<?> getResponseData() {
		return responseData;
	}
	public void setResponseData(List<?> responseData) {
		this.responseData = responseData;
	}
	private String errorMessage;
	private Object responseObject;
	private List<?> responseData;


}
