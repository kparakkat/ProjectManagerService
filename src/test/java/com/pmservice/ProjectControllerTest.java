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

import com.pmservice.models.Project;
import com.pmservice.models.ResultData;
import com.pmservice.models.Task;

public class ProjectControllerTest extends AbstractTest{
	@Test
	public void getAllProjects() throws Exception {
		String uri = "/project/getAllProjects";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Project[] projects = super.mapFromJson(content, Project[].class);
		assertTrue(projects.length > 0);
	}
	
	@Test
	public void getByProjectId() throws Exception {
		String uri = "/project/getByProjectId/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Project project = super.mapFromJson(content, Project.class);
		assertTrue(project != null);
	}
	
	@Test
	public void createProject() throws Exception {
		String uri = "/project/addProject";
		Project project = new Project();
		project.setProject("STL Tool Integration");
		Date startDate = new Date();
		LocalDateTime localEndDateTime = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localEndDateTime = localEndDateTime.plusDays(20);
		Date endDate = Date.from(localEndDateTime.atZone(ZoneId.systemDefault()).toInstant());
		project.setStartdate(startDate);
		project.setEnddate(endDate);
		project.setPriority(5);
		
		String inputJson = super.mapToJson(project);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ResultData response = super.mapFromJson(content, ResultData.class);
		assertEquals(response.getResponse(), "Added Project Successfully !");
	}
		
	@Test
	public void updateProject() throws Exception {
		String uri = "/project/updateProject";
		Project project = new Project();
		Date startDate = new Date();
		LocalDateTime localEndDateTime = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localEndDateTime = localEndDateTime.plusDays(60);
		Date endDate = Date.from(localEndDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
		project.setProjectid(6);
		project.setProject("Spring Boot Version Upgrade");
		project.setStartdate(startDate);
		project.setEnddate(endDate);
		project.setPriority(1);
		
		String inputJson = super.mapToJson(project);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ResultData response = super.mapFromJson(content, ResultData.class);
		assertEquals(response.getResponse(), "Updated Successfully !");
	}
	
	@Test
	public void saveCreateProject() throws Exception {
		String uri = "/project/saveProject";
		Project project = new Project();
		project.setProject("Oracle Exadata Integration");
		Date startDate = new Date();
		LocalDateTime localEndDateTime = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localEndDateTime = localEndDateTime.plusDays(20);
		Date endDate = Date.from(localEndDateTime.atZone(ZoneId.systemDefault()).toInstant());
		project.setStartdate(startDate);
		project.setEnddate(endDate);
		project.setPriority(5);
		
		String inputJson = super.mapToJson(project);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Project response = super.mapFromJson(content, Project.class);
		assertTrue(response != null);
	}
		
	@Test
	public void saveUpdateProject() throws Exception {
		String uri = "/project/saveProject";
		Project project = new Project();
		Date startDate = new Date();
		LocalDateTime localEndDateTime = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localEndDateTime = localEndDateTime.plusDays(60);
		Date endDate = Date.from(localEndDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
		project.setProjectid(5);
		project.setProject("Brokerage Reporting Java Micro Services");
		project.setStartdate(startDate);
		project.setEnddate(endDate);
		project.setPriority(1);
		
		String inputJson = super.mapToJson(project);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Project response = super.mapFromJson(content, Project.class);
		assertTrue(response != null);
	}
	
	@Test
	public void deleteProject() throws Exception {
		String uri = "/project/deleteProject/7";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ResultData response = super.mapFromJson(content, ResultData.class);
		assertEquals(response.getResponse(), "Deleted Successfully !");
	}
}
