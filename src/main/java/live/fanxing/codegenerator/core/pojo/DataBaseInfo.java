package live.fanxing.codegenerator.core.pojo;

import live.fanxing.codegenerator.core.CreateCode;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Fanxing
 * 数据库信息 - 最顶层
 */
@Data
@Component
public class DataBaseInfo {
    String dataBaseName;
    List<DataBaseTable> dataBaseTables = new ArrayList<>();

    protected void init(String dataBaseName,List<DataBaseTable> dataBaseTables){
        this.dataBaseName = dataBaseName;
        this.dataBaseTables = dataBaseTables;
    }

    public void setTable(DataBaseTable dataBaseTable){
        this.dataBaseTables.add(dataBaseTable);
    }



}
