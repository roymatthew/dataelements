/**
 * 
 */
package com.demo.microservice.dataelements.service;

import com.demo.microservice.dataelements.entity.DataElement;
import com.demo.microservice.dataelements.persistence.DataElementRepository;
import com.demo.microservice.dataelements.translator.DataElementsTranslator;
import com.demo.microservice.dataelements.vo.DataElementVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rmathew
 *
 */
@Service
public class DataElementServiceImpl implements DataElementService {

	@Autowired
	private DataElementRepository dataElementRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.microservice.dataelements.service.DataElementService#
	 * getDataElementsByElementType(java.lang.String)
	 */
	@Override
	public List<DataElement> getDataElementsByElementType(final String elementType) {
		// TODO Auto-generated method stub
		return dataElementRepository.findByElementType(elementType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.microservice.dataelements.service.DataElementService#
	 * addNewDataElement(com.demo.microservice.dataelements.vo.DataElementVO)
	 */
	@Override
	public DataElement addNewDataElement(final DataElementVO dataElementVO) {
		// TODO Auto-generated method stub
		return dataElementRepository.save(DataElementsTranslator.translateVOtoEntity(dataElementVO));
	}

	@Override
	public DataElementVO getDataElementById(final Integer id) {
		return new DataElementVO();
	}

}
