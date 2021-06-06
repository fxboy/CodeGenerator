package live.fanxing.codegenerator.core.gen;

import lombok.Data;
import sun.tools.jconsole.Tab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther fanxing
 * 2021/6/6
 */
@Data
public class Table {
    // 表名
    String tableName;
    // 类名
    String className;
    // 属性名
    String attrName;

    // 表中的字段
    List<Filed> fileds;
    Map<String,Filed> filedMap;

    // 表的外键关系(或自定义关系)
    List<Table> left;
    Map<String, Table> leftMap;

    // 关联查询的时候的on
    List<Keyon> keyOns;


    public Table(String tableName, String className, String attrName) {
        this.tableName = tableName;
        this.className = className;
        this.attrName = attrName;
        this.fileds = new ArrayList<>();
        this.left = new ArrayList<>();
        this.filedMap = new HashMap<>();
        this.leftMap = new HashMap<>();
        this.keyOns = new ArrayList<>();
    }

    public void addFiled(String key,Filed filed){
        this.fileds.add(filed);
        this.filedMap.put(key,filed);
    }

    public void addLeft(String key,Keyon keyOn,Table table){
        this.left.add(table);
        this.leftMap.put(key, table);
        this.keyOns.add(keyOn);
    }
}
