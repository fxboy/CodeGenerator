package live.fanxing.codegenerator.core.pojo;

import lombok.Data;

import java.util.List;

/**
 * @auther Fanxing
 * 这是一个简介
 */
@Data
public class DataBaseInfo {
    String dataBaseName;
    List<DataBaseTable> dataBaseTables;

    protected void init(String dataBaseName,List<DataBaseTable> dataBaseTables){
        this.dataBaseName = dataBaseName;
        this.dataBaseTables = dataBaseTables;

    }
}
