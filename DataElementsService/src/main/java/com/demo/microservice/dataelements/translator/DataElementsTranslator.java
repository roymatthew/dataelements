/**
 * 
 */
package com.demo.microservice.dataelements.translator;

import com.demo.microservice.dataelements.entity.DataElement;
import com.demo.microservice.dataelements.vo.DataElementVO;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jboss.logging.Logger;

/**
 * @author rmathew
 *
 */
@Slf4j
public class DataElementsTranslator {

    /**
     * @param dataElementsByElementType
     * @return
     */
    public static Collection<DataElementVO> translateEntityCollection(
        final List<DataElement> dataElementsByElementType) {
    	log.debug("Enter");
        final List<DataElementVO> voList = new ArrayList<>();
        for (DataElement dataElement : dataElementsByElementType)
        {
            final DataElementVO vo = new DataElementVO();
            vo.setId(dataElement.getId());
            vo.setDisplayName(dataElement.getDisplayName());
            vo.setElementName(dataElement.getElementName());
            vo.setElementType(dataElement.getElementType());
            vo.setGroupName(dataElement.getGroupName());
            voList.add(vo);
        	log.debug("Translated  DataElement with Id: " + dataElement.getId());
        }
        return voList;
    }

    /**
     * @param dataElementVO
     * @return
     */
    public static DataElement translateVOtoEntity(final DataElementVO dataElementVO) {
        final DataElement dataElement = new DataElement();
        dataElement.setDisplayName(dataElementVO.getDisplayName());
        dataElement.setElementName(dataElementVO.getElementName());
        dataElement.setElementType(dataElementVO.getElementType());
        dataElement.setGroupName(dataElementVO.getGroupName());
        
        return dataElement;
    }

    /**
     * @param addNewDataElement
     * @return
     */
    public static DataElementVO translateEntity(DataElement dataElement) {
        final DataElementVO vo = new DataElementVO();
        vo.setId(dataElement.getId());
        vo.setDisplayName(dataElement.getDisplayName());
        vo.setElementName(dataElement.getElementName());
        vo.setElementType(dataElement.getElementType());
        vo.setGroupName(dataElement.getGroupName());
        return vo;
    }

}
