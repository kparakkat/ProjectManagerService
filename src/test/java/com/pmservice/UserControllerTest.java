package com.pmservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pmservice.models.User;

public class UserControllerTest extends AbstractTest {
	@Test
	public void getByUserId() throws Exception {
		String uri = "/user/getByUserId/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		User user = super.mapFromJson(content, User.class);
		assertTrue(user != null);
	}
	
	@Test
	public void createUser() throws Exception {
		String uri = "/user/addUser";
		User user = new User();
		user.setFirstname("Jack");
		user.setLastname("Stephen");
		user.setEmployeeid(12345);
		
		String inputJson = super.mapToJson(user);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Added User Successfully !");
	}
	
	@Test
	public void updateUser() throws Exception {
		String uri = "/user/updateUser";
		User user = new User();
		user.setUserid(16);
		user.setFirstname("Sara");
		user.setLastname("John");
		user.setEmployeeid(12345678);
		
		String inputJson = super.mapToJson(user);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Updated Successfully !");
	}
	
	@Test
	public void deleteUser() throws Exception {
		String uri = "/user/deleteUser/15";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Deleted Successfully !");
	}
}