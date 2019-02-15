package com.demo.microservice.dataelements.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.demo.microservice.dataelements.entity.DataElement;
import com.demo.microservice.dataelements.persistence.DataElementRepository;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.util.EntityManagerProvider;
import com.github.database.rider.junit5.DBUnitExtension;

@ExtendWith({DBUnitExtension.class, SpringExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
class DataElementsServiceIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private DataElementRepository repository;
	
	private static final Integer TEST_ID = Integer.valueOf("1000");
	
	private static final Integer TEST_ID_ONE = Integer.valueOf("1");
	
	private static final Integer TEST_ID_TWO = Integer.valueOf("2");
	
    public ConnectionHolder getConnectionHolder() {
        // Return a function that retrieves a connection from our data source
        return () -> dataSource.getConnection();
    }

	@Test
	void test() {
		DataElement savedEntityOne = repository.save(getMockDataElelement());
		Assert.assertNotNull(savedEntityOne);
		Assert.assertEquals(TEST_ID_ONE, savedEntityOne.getId());
		
		DataElement savedEntityTwo = repository.save(getMockDataElelement());
		Assert.assertNotNull(savedEntityTwo);
		Assert.assertEquals(TEST_ID_TWO, savedEntityTwo.getId());
	}
	
    @Test
    @DataSet("dataelement.yml")
    public void shouldListDataElements() {
        //List<DataElement> list = EntityManagerProvider.em().createQuery("select d from DataElement d").getResultList();
        List<DataElement> list = repository.findAll();
        assertThat(list).isNotNull().isNotEmpty().hasSize(2);
        list.stream().findFirst().map( de -> assertThat(de.getElementName().equals("JUnit")));
    }
    
    @Test
    @DataSet("dataelement.yml")
    public void shouldListDataElementByElementType() {
        //List<DataElement> list = EntityManagerProvider.em().createQuery("select d from DataElement d").getResultList();
        final List<DataElement> list = repository.findByElementType("Jtest");
        assertThat(list).isNotNull().isNotEmpty().hasSize(1);
        list.stream().findFirst().map( de -> assertThat(de.getElementName().equals("JUnit")));
    }
	
	@Test
    @DisplayName("GET /dataelements/elementtype/{elementType}")
	@DataSet("dataelement.yml")
	void testForFindingDataElementByType() throws Exception
	{
		MvcResult result = mockMvc.perform(get("/dataelements/elementtype/{elementType}", "Jtest"))
        // Validate the response code and content type
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        // Validate the headers
        //.andExpect(header().string(HttpHeaders.ETAG, "\"1\""));
        //.andExpect(header().string(HttpHeaders.LOCATION, "/product/1"));
		.andReturn();
		
		Assert.assertNotNull(result.getResponse());

	}
	

	private DataElement getMockDataElelement() {
		final DataElement dataElement = new DataElement();
		dataElement.setDisplayName("Test Display Name");
		dataElement.setElementName("Test Name");
		dataElement.setElementType("Test Type");
		dataElement.setGroupName("Test Group");
		dataElement.setId(TEST_ID);
		return dataElement;
	}

}
