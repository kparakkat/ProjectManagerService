package com.pmservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pmservice.models.ResultData;
import com.pmservice.models.Task;

public class TaskControllerTest extends AbstractTest{

	@Test
	public void getAllTasks() throws Exception {
		String uri = "/task/getAllTasks";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Task[] tasks = super.mapFromJson(content, Task[].class);
		assertTrue(tasks.length > 0);
	}
	
	@Test
	public void getByTaskId() throws Exception {
		String uri = "/task/getByTaskId/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Task task = super.mapFromJson(content, Task.class);
		assertTrue(task != null);
	}
	
	@Test
	public void getByProjectId() throws Exception {
		String uri = "/task/getByProjectId/3";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Task[] tasks = super.mapFromJson(content, Task[].class);
		assertTrue(tasks.length > 0);
	}
	
	@Test
	public void saveCreateTask() throws Exception {
		String uri = "/task/saveTask";
		Task task = new Task();
		task.setParenttaskid(2);
		task.setProjectid(3);
		task.setTask("Framework Design");
		Date startDate = new Date();
		LocalDateTime localEndDateTime = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localEndDateTime = localEndDateTime.plusDays(10);
		Date endDate = Date.from(localEndDateTime.atZone(ZoneId.systemDefault()).toInstant());
		task.setStartdate(startDate);
		task.setEnddate(endDate);
		task.setPriority(5);
		task.setStatus("In Progress");
		
		String inputJson = super.mapToJson(task);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Task response = super.mapFromJson(content, Task.class);
		assertTrue(response != null);
	}
	
	@Test
	public void saveUpdateTask() throws Exception {
		String uri = "/task/saveTask";
		Task task = new Task();
		task.setTaskid(1);
		task.setParenttaskid(1);
		task.setProjectid(3);
		task.setTask("Requirement Gathering - Use case Analysis");
		Date startDate = new Date();
		LocalDateTime localEndDateTime = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localEndDateTime = localEndDateTime.plusDays(10);
		Date endDate = Date.from(localEndDateTime.atZone(ZoneId.systemDefault()).toInstant());
		task.setStartdate(startDate);
		task.setEnddate(endDate);
		task.setPriority(1);
		task.setStatus("In Progress");
		
		String inputJson = super.mapToJson(task);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Task response = super.mapFromJson(content, Task.class);
		assertTrue(response != null);
	}
	
	@Test
	public void deleteTask() throws Exception {
		String uri = "/task/deleteTask/8";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ResultData response = super.mapFromJson(content, ResultData.class);
		assertEquals(response.getResponse(), "Deleted Successfully !");
	}
}
