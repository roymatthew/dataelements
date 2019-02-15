/**
 * 
 */
package com.demo.microservice.dataelements.service;

import com.demo.microservice.dataelements.entity.DataElement;
import com.demo.microservice.dataelements.vo.DataElementVO;
import java.util.List;
import java.util.Optional;


/**
 * @author rmathew
 *
 */
public interface DataElementService {
    
	List<DataElement> getDataElementsByElementType(final String elementType);

    /**
     * @param dataElementVO
     * @return
     */
    DataElement addNewDataElement(DataElementVO dataElementVO);

	DataElementVO getDataElementById(final Integer id);

}
