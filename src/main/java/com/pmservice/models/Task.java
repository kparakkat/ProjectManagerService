package com.pmservice.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskid;
	
	private Integer parenttaskid;
	
	private Integer projectid;
	
	private String task;
	
	private Date startdate;
	
	private Date enddate;
	
	private Integer priority;
	
	private String status;
	
	public Task() {}
	
	public Integer getTaskid() {
		return taskid;
	}
	
	public void setTaskid(Integer value) {
		taskid = value;
	}
	
	public Integer getParenttaskid() {
		return parenttaskid;
	}
	
	public void setParenttaskid(Integer value) {
		parenttaskid = value;
	}
	
	public Integer getProjectid() {
		return projectid;
	}
	
	public void setProjectid(Integer value) {
		projectid = value;
	}
	
	public String getTask() {
		return task;
	}
	
	public void setTask(String value) {
		this.task = value;
	}
	
	public Date getStartdate() {
		return startdate;
	}
	
	public void setStartdate(Date value) {
		startdate = value;
	}
	
	public Date getEnddate() {
		return enddate;
	}
	
	public void setEnddate(Date value) {
		enddate = value;
	}
	
	public Integer getPriority() {
		return priority;
	}
	
	public void setPriority(Integer value) {
		priority = value;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String value) {
		this.status = value;
	}
}
