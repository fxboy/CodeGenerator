package ${tableEntities.packageName};

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ${tableEntities.tableName} implements Serializable {
        private static final long serialVersionUID = ${tableEntities.serialVersionUID};

<#list tableEntities.attributes as map>
    <#list map?keys as key>
        @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
        private ${map[key]} ${key};
    </#list>
</#list>

<#list tableEntities.attributes as map>
    <#list map?keys as key>

        public void set${key?cap_first}(${map[key]} ${key}){
            this.${key} = ${key};
        }

        public ${map[key]} get${key?cap_first}(){
            return this.${key};
        }

    </#list>
</#list>

}