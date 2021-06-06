package live.fanxing.codegenerator.core.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @auther Fanxing
 * 表信息 第二层
 */

@Getter
@Setter
@ToString
public class DataBaseTable {

    // 表名
    String tableName;
    // 类名
    String className;
    // 方法名
    String attributeName;
    //所有的字段名
    List<DataBaseFiled> dataBaseFileds;



    //用来保存sql语句的方法
    List<DataBaseSql> dataBaseSqls;

    MapperInfo mapperInfo;

    TableEntity tableEntities;

    public void build(String tableName, String className, String attributeName, List<DataBaseFiled> dataBaseFileds, List<DataBaseSql> dataBaseSqls,TableEntity tableEntities,MapperInfo mapperInfo) {
        this.tableName = tableName;
        this.className = className;
        this.attributeName = attributeName;
        this.dataBaseFileds = dataBaseFileds;
        this.dataBaseSqls = dataBaseSqls;
        this.tableEntities = tableEntities;
        this.mapperInfo = mapperInfo;
    }
}
