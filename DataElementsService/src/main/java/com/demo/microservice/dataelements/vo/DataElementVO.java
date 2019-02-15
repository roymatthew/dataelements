/**
 * 
 */
package com.demo.microservice.dataelements.vo;


/**
 * @author rmathew
 *
 */
public class DataElementVO {
    

    private Integer id;
    private String elementName;
    private String elementType;
    private String groupName;
    private String displayName;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getElementName() {
        return elementName;
    }
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }
    public String getElementType() {
        return elementType;
    }
    public void setElementType(String elementType) {
        this.elementType = elementType;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    
    @Override
    public String toString() {
        return "DataElementVO [id=" + id + ", elementName=" + elementName + ", elementType=" + elementType
            + ", groupName=" + groupName + ", displayName=" + displayName + "]";
    }

}
