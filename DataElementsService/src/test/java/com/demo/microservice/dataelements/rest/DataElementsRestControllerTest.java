/**
 * 
 */
package com.demo.microservice.dataelements.rest;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.microservice.dataelements.entity.DataElement;
import com.demo.microservice.dataelements.service.DataElementService;
import com.demo.microservice.dataelements.vo.DataElementVO;

/**
 * @author rmathew
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DataElementsRestControllerTest {
	
	@MockBean
	private DataElementService dataElementService;
	
	@Autowired
	private MockMvc mockMvc;
	
	private static final String TEST_ELEMENT_TYPE = "TEST";
	private static final Integer TEST_ID = Integer.valueOf("1000");
	
	@Test
	@DisplayName("GET /dataelements/elementtype/{elementType}")
	void testGetDataElementsByElementType() throws Exception
	{
		doReturn(getMockDataElementsList()).when(dataElementService).getDataElementsByElementType(TEST_ELEMENT_TYPE);
		mockMvc.perform(get("/dataelements/elementtype/{elementType}", TEST_ELEMENT_TYPE)).andExpect(status().isOk());		
		
	}
	
	@Test
	@DisplayName("GET /dataelements/elementtype/{elementType}/id/{id}")
	void testGetDataElementById() throws Exception
	{
		doReturn(getMockDataElement()).when(dataElementService).getDataElementById(TEST_ID);
		mockMvc.perform(get("/dataelements/elementtype/{elementType}/id/{id}", TEST_ELEMENT_TYPE, TEST_ID)).andExpect(status().isOk());
	}

	private DataElementVO getMockDataElement() {
		final DataElementVO dataElement = new DataElementVO();
		dataElement.setId(Integer.valueOf("1000"));
		return dataElement;
	}

	private List<DataElement> getMockDataElementsList() {
		final List<DataElement> aList = new ArrayList<>();
		final DataElement dataElement = new DataElement();
		dataElement.setId(Integer.valueOf("1000"));
		aList.add(dataElement);
		return aList;
	}

}
