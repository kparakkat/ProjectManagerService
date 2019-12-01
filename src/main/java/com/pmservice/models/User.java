package com.pmservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userid;
	
	private String firstname;
	
	private String lastname;
	
	private Integer employeeid;
	
	private Integer projectid;
	
	private Integer taskid;
	
	public User() {}
	
	public Integer getUserid() {
		return userid;
	}
	
	public void setUserid(Integer value) {
		userid = value;
	}
	
	public void setLeaveid(Integer value) {
		this.userid = value;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String value) {
		this.firstname = value;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String value) {
		this.lastname = value;
	}
	
	public Integer getEmployeeid() {
		return employeeid;
	}
	
	public void setEmployeeid(Integer value) {
		this.employeeid = value;
	}
		
	public Integer getProjectid() {
	 	return projectid;
	}
	
	public void setProjectid(Integer value) {
		this.projectid = value;
	}
		
	public Integer getTaskid() {
		return taskid;
	}
	
	public void setTaskid(Integer value) {
		this.taskid = value;
	}
}
