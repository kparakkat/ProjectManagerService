package com.pmservice.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer projectid;
	
	private String project;
	
	private Date startdate;
	
	private Date enddate;
	
	private Integer priority;
	
	public Project() {}
	
	public Integer getProjectid() {
		return projectid;
	}
	
	public void setProjectid(Integer value) {
		projectid = value;
	}
	
	public String getProject() {
		return project;
	}
	
	public void setProject(String value) {
		this.project = value;
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
}
