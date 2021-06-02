package live.fanxing.codegenerator.core.pojo;

import live.fanxing.codegenerator.core.CreateCode;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @auther Fanxing
 * 这是一个简介
 */
@Data
@Component
public class DataBaseInfo {
    String dataBaseName;
    List<DataBaseTable> dataBaseTables;




    protected void init(String dataBaseName,List<DataBaseTable> dataBaseTables){
        this.dataBaseName = dataBaseName;
        this.dataBaseTables = dataBaseTables;
    }


}
