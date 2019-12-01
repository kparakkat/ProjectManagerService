package com.pmservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pmservice.models.ParentTask;
import com.pmservice.models.ResultData;

public class ParentTaskControllerTest extends AbstractTest {
	@Test
	public void getByParentTaskId() throws Exception {
		String uri = "/parentTask/getByParentTaskId/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ParentTask parentTask = super.mapFromJson(content, ParentTask.class);
		assertTrue(parentTask != null);
	}
	
	@Test
	public void saveCreateParentTask() throws Exception {
		String uri = "/parentTask/saveParentTask";
		ParentTask parentTask = new ParentTask();
		parentTask.setParenttask("Q1 Maintenance Release");
		
		String inputJson = super.mapToJson(parentTask);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ParentTask response = super.mapFromJson(content, ParentTask.class);
		assertTrue(response != null);
	}
	
	@Test
	public void saveUpdateParentTask() throws Exception {
		String uri = "/parentTask/saveParentTask";
		ParentTask parentTask = new ParentTask();
		
		parentTask.setParenttaskid(2);
		parentTask.setParenttask("Technical Design Document Preparation, Review and Approval");
		
		String inputJson = super.mapToJson(parentTask);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ParentTask response = super.mapFromJson(content, ParentTask.class);
		assertTrue(response != null);
	}
	
	@Test
	public void deleteParentTask() throws Exception {
		String uri = "/parentTask/deleteParentTask/7";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ResultData response = super.mapFromJson(content, ResultData.class);
		assertEquals(response.getResponse(), "Deleted Successfully !");
	}
}
