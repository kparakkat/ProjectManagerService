package com.pmservice.models;

public class ResultData {
  private String response;
  
  public ResultData() {}
  
  public ResultData(String resp) {
	  this.response = resp;
  }
  public String getResponse() {
		return response;
  }
	
  public void setResponse(String value) {
		this.response = value;
  }
}
