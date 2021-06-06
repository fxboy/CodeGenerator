package live.fanxing.codegenerator.core.gen;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther fanxing
 * 2021/6/6
 */
@Data
public class DataBase {
    String databaseName;
    String packageName;
    List<Table> tables = new ArrayList<>();
    Map<String,Table> tableMap = new HashMap<>();

    public void addTables(String key,Table table){
        this.tables.add(table);
        this.tableMap.put(key, table);
    }

}
