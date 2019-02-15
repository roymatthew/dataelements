/**
 * 
 */
package com.demo.microservice.dataelements.persistence;

import com.demo.microservice.dataelements.entity.DataElement;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rmathew
 *
 */
@Repository
public interface DataElementRepository extends JpaRepository<DataElement, String>{
    
    public List<DataElement> findByElementType(final String elementType);

}
