package live.fanxing.codegenerator.core;

import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import live.fanxing.codegenerator.core.gen.DataBase;
import live.fanxing.codegenerator.core.gen.Filed;
import live.fanxing.codegenerator.core.gen.Keyon;
import live.fanxing.codegenerator.core.gen.Table;
import live.fanxing.codegenerator.core.pojo.DataBaseInfo;
import live.fanxing.codegenerator.file.FileCreate;
import live.fanxing.codegenerator.util.DataBaseUtils;
import live.fanxing.codegenerator.util.ToolsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sun.tools.jconsole.Tab;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @auther Fanxing
 * 生成代码信息工具
 */
@Component
public class Generator {
    // 加载
    @Autowired
    @Qualifier("entity")
    FileCreate EntityfileCreate;

    @Value("${cr.package.dao}")
    String packageDaoName;

    @Value("${cr.package.entity}")
    String packagEntityeName;

    @Autowired
    DataBaseUtils dataBaseUtils;

    @Value("${cr.database.name}")
    String databseName;
    // 通用的内容
    //数据库信息
    DataBaseInfo dataBaseInfo = new DataBaseInfo();

    DataBase dataBase = new DataBase();
    //获取的表名集合
    List<String> tableNames;

    String modelPath = "G:\\classTest\\CodeGenerator\\src\\main\\resources\\ftl";
    String outPath = "B:\\new\\";
    String packageName = "";

    public Generator(){

    }

    public Generator init(String packageName,String outPath,String modelPath) throws Exception {
        if(packageName == null){
            throw new Exception("项目的包名不能为空");
        }
        this.packageName = packageName;
        if(outPath == null){
            throw new Exception("项目的输出路径不能为空");
        }
        this.outPath = outPath;
        if(modelPath != null){
            this.modelPath = modelPath;
        }
        this.dataBase.setDatabaseName(this.databseName);
        this.dataBase.setPackageName(this.packageName);
        tableNames = dataBaseUtils.getTableListByNowDataBase();
        return this;
    }


    private void createSql(String tableName){};

    private void createEntity(){};

    private void createDao(){};

    private void createController(){};

    private void createMapper(){};


    // 某一个表中的字段
    List<Map<String, Object>> fields;
    // 当前表中的外键关系
    List<Map<String, Object>> forginkeys;


    private int generator(int index){
        if(index >= this.tableNames.size()){
            // 开始下一步操作
            this.run(0);
            return index;
        }
        String[] name = ToolsUtils.jx(tableNames.get(index));
        // 创建Table
        Table table = new Table(name[0],name[1],name[2]);
        this.dataBase.addTables(name[0],table);
        index++;
        return this.generator(index);
    }


    List<Table> tables = new ArrayList<>();
    private int run(int index){
        if(index >= this.dataBase.getTables().size()){
            // 结束后将修改后的内容重新覆盖以前的
            this.dataBase.setTables(tables);
            return index;
        }
        String name = this.dataBase.getTables().get(index).getTableName();
        // 获取当前表中的字段
        this.fields = dataBaseUtils.getFieldListByTableName(name);
        this.forginkeys = dataBaseUtils.getForeginKeyByTableName(name);
        // 遍历当前表中的字段
        Table table = forFields(0,this.dataBase.getTables().get(index));
        tables.add(table);
        index++;
        return run(index);
    }





    /**
     * 遍历字段
     * */
    private Table forFields(int index, Table table){
        if(index >= this.fields.size()){
            return forForginkeys(0,table);
        }
        Map map = this.fields.get(index);
        String[] name = ToolsUtils.jx(map.get("COLUMN_NAME").toString());
        // 创建filed
        Filed filed = new Filed(map.get("COLUMN_KEY").equals("PRI"),map.get("EXTRA").toString().contains("auto_increment"),name[0],name[2]);
        table.addFiled(name[0],filed);
        index++;
        return forFields(index,table);
    }

    // 根据外键补缺
    private Table forForginkeys(int index,Table table){
        if(index >= this.forginkeys.size()){
            return table;
        }
        Map map = this.forginkeys.get(index);
        String[] name = ToolsUtils.jx(map.get("TABLE_NAME").toString());
        Keyon keyon = new Keyon(map.get("TABLE_NAME").toString() +"." + map.get("COLUMN_NAME").toString(),map.get("REFERENCED_TABLE_NAME").toString() + "." +  map.get("REFERENCED_COLUMN_NAME").toString());
        table.addLeft(name[0],keyon,dataBase.getTableMap().get(name[0]));
        index++;
        return forForginkeys(index,table);
    }


    public void build(){
        this.generator(0);
        System.out.println(JSON.toJSONString(this.dataBase, SerializerFeature.DisableCircularReferenceDetect));
    }



}
