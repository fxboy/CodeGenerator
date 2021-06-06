package live.fanxing.codegenerator.core.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @auther Fanxing
 * 表生成实体类
 */
@Data
public class TableEntity {
    long serialVersionUID;
    String tableName;
    String packageName;
    List<Attributes> attributes = new ArrayList<>();

    public TableEntity(){
        this.serialVersionUID = 1L;
        this.attributes = new ArrayList<>();
    }

    public TableEntity( String tableName, String packageName) {
        this.serialVersionUID = 1L;
        this.tableName = tableName;
        this.packageName = packageName;
    }

    public TableEntity(String tableName, String packageName, List<Attributes> attributes) {
        this.serialVersionUID = 1L;
        this.tableName = tableName;
        this.packageName = packageName;
        this.attributes = attributes;
    }

    public void setAttr(Attributes attr){
        this.attributes.add(attr);
    }


}
