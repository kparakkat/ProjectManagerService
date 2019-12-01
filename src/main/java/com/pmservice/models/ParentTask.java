package com.pmservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParentTask {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer parenttaskid;
	
	private String parenttask;
	
	public ParentTask() {}
	
	public Integer getParenttaskid() {
		return parenttaskid;
	}
	
	public void setParenttaskid(Integer value) {
		parenttaskid = value;
	}
	
	public String getParenttask() {
		return parenttask;
	}
	
	public void setParenttask(String value) {
		this.parenttask = value;
	}
}
