package com.stackroute.springboot.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.springboot.model.IPolicy;
import com.stackroute.springboot.services.IPolicyServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(IPolicyController.class)
public class IPolicyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IPolicyServiceImpl policyservice;

	private IPolicy policyObj;

	@Before
	public void setup() {
		policyObj = new IPolicy();

		policyObj.setIpId(1);
		policyObj.setIpTitle("Health");
		policyObj.setIpDesc("Life Term Plan");
		policyObj.setIpPremium(2000);
	}

	@After
	public void tearDown() {
		policyObj = null;
	}

//	http://localhost:8080/api/v1/addpolicy  -- POST  --- Body (JSON)

	public void testSavePolicySuccess() throws Exception {
		Mockito.when(policyservice.savePolicy(policyObj)).thenReturn(policyObj);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/addpolicy").contentType(MediaType.APPLICATION_JSON)
				.content(asJSON(policyObj))).andExpect(status().isCreated());
	}

	public void testSavePolicyFailure() throws Exception {
		Mockito.when(policyservice.savePolicy(policyObj)).thenReturn(policyObj);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/addpolicy").contentType(MediaType.APPLICATION_JSON)
				.content(asJSON(policyObj))).andExpect(status().isConflict());

	}

	public static String asJSON(IPolicy policyObj) {
		try {
			String policyObj1 = new ObjectMapper().writeValueAsString(policyObj);
			return policyObj1;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
