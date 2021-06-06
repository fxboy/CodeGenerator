package ${entity.packageName};

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
* @auther
* ${entity.className} 实体类
*/
public class ${entity.className} implements Serializable{
    private static final long serialVersionUID = ${entity.serialVersionUID};
<#list entity.attributesList as attributes>
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private ${attributes.attributeType} ${attributes.attributeName};
</#list>

<#list entity.attributesList as attributes>
    public void set${attributes.attributeName?cap_first}(${attributes.attributeType} ${attributes.attributeName}){
        this.${attributes.attributeName} =  ${attributes.attributeName};
    }

    public ${attributes.attributeType} get${attributes.attributeName?cap_first}(){
        return this.${attributes.attributeName};
    }

</#list>
}
