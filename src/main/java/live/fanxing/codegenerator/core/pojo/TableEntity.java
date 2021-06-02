package live.fanxing.codegenerator.core.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @auther Fanxing
 * 这是一个简介
 */
@Data
public class TableEntity {
    long serialVersionUID;
    String tableName;
    String packageName;
    List<Map<String,String>> attributes;

    public TableEntity(){
        this.serialVersionUID = 1L;
    }
}
