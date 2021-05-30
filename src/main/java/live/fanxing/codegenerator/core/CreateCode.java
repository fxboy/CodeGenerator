package live.fanxing.codegenerator.core;

import live.fanxing.codegenerator.core.enums.SqlType;
import live.fanxing.codegenerator.core.pojo.DataBaseFiled;
import live.fanxing.codegenerator.core.pojo.DataBaseInfo;
import live.fanxing.codegenerator.core.pojo.DataBaseSql;
import live.fanxing.codegenerator.core.pojo.DataBaseTable;
import live.fanxing.codegenerator.util.DataBaseUtils;
import live.fanxing.codegenerator.util.ToolsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther Fanxing
 * 这是一个简介
 */
@Component
public class CreateCode {
    @Autowired
    DataBaseUtils dataBaseUtils;

    List<String> tableNames;
    DataBaseInfo dataBaseInfo;
    List<DataBaseTable> dataBaseTables;

    Integer index = 0;

    public CreateCode init(DataBaseInfo dataBaseInfo){
        tableNames  = dataBaseUtils.getTableListByNowDataBase();
        this.dataBaseInfo = dataBaseInfo;
        this.dataBaseInfo.setDataBaseName("数据库名");
        this.dataBaseTables = new ArrayList<>();
        return this;
    }

    // 生成 sql语句,根据表的索引，通过递归来生成
    private CreateCode create(){
        DataBaseTable dataBaseTable = new DataBaseTable();
        // 如果当前的索引要是大于等于它的话，就不继续调用了
        if(index >= tableNames.size()){
            return this;
        }

        List<DataBaseFiled> dataBaseFileds = new ArrayList<>();
        List<DataBaseSql> dataBaseSqls = new ArrayList<>();
        //DataBaseInfo dataBaseInfo = new DataBaseInfo();
        String tableName = tableNames.get(index);
        String[] ab;
        ab = ToolsUtils.jx(tableName);
        //System.out.println("表名：" + ab[0]+"=====" + ab[1] + "====" + ab[2]);
        // 开始解析字段
        List<Map<String,Object>>  fields = dataBaseUtils.getFieldListByTableName(tableName);
        List<Map<String,Object>>  forginkeys = dataBaseUtils.getForeginKeyByTableName(tableName);
        StringBuffer select = new StringBuffer("select ");
        StringBuffer where = new StringBuffer(" where 1 = 1 ");
        StringBuffer update = new StringBuffer("update ").append(tableName).append(" set ");
        StringBuffer insert = new StringBuffer("insert into ").append(tableName).append("(");
        StringBuffer values = new StringBuffer("values(");
        StringBuffer delete = new StringBuffer("delete from ").append(tableName);
        StringBuffer leftjoin = new StringBuffer("select ");
        StringBuffer _leftjoin = new StringBuffer();
        for (Map<String, Object> forginkey : forginkeys) {
            _leftjoin.append(" left join ").append(forginkey.get("REFERENCED_TABLE_NAME")).append(" ").append(ToolsUtils.getSzm(forginkey.get("REFERENCED_TABLE_NAME").toString())).append(" on ").append(ToolsUtils.getSzm(tableName)).append(".").append(forginkey.get("COLUMN_NAME")).append(" = ").append(ToolsUtils.getSzm(forginkey.get("REFERENCED_TABLE_NAME").toString())).append(".").append(forginkey.get("REFERENCED_COLUMN_NAME"));
        }
        for (Map<String, Object> field : fields) {

            String[] abs = ToolsUtils.jx(field.get("COLUMN_NAME").toString());
            field.put("SDX_COLUMN_NAME",abs[1]);
            field.put("TFS_COLUMN_NAME",abs[2]);
            dataBaseFileds.add(new DataBaseFiled(abs[0],abs[1],abs[2]));
            //System.out.println(field.get("COLUMN_NAME") + "::" + field.get("SDX_COLUMN_NAME")+"::" + field.get("TFS_COLUMN_NAME"));
            // 开始拼接sql语句，比如查询
            select.append(field.get("COLUMN_NAME").toString()).append(" as ").append(field.get("TFS_COLUMN_NAME").toString()).append(fields.get(fields.size() - 1).equals(field)?" ":",");
            leftjoin.append(ToolsUtils.getSzm(tableName)).append(".").append(field.get("COLUMN_NAME").toString()).append(fields.get(fields.size() - 1).equals(field)?" ":",");
            if(field.get("COLUMN_KEY").equals("PRI")) {
                where.append(" and ").append(field.get("COLUMN_NAME").toString()).append(" = #{" + field.get("TFS_COLUMN_NAME") + "}");
            }
            update.append(field.get("COLUMN_NAME").toString()).append(" = ").append("#{"+  field.get("TFS_COLUMN_NAME") +"}").append(fields.get(fields.size() - 1).equals(field)?" ":",");
            if(!field.get("EXTRA").toString().contains("auto_increment")){
                insert.append(field.get("COLUMN_NAME").toString()).append(fields.get(fields.size() - 1).equals(field)?")":",");
                values.append("#{"+ field.get("TFS_COLUMN_NAME") +"}").append(fields.get(fields.size() - 1).equals(field)?")":",");
            }
        }
        select.append(" from " + tableName).append(where.toString());
        leftjoin.append(" from " + tableName).append(" ").append(ToolsUtils.getSzm(tableName)).append(_leftjoin);
        update.append(where.toString());
        insert.append(values);
        delete.append(where);
        DataBaseSql var1 = new DataBaseSql(SqlType.SELECT_BY_ID,"selectById",select.toString(),"List<"+ab[1]+">");
        dataBaseSqls.add(var1);
        // 开始判断是否有主键
//        System.out.println("查询：" + select);
//        System.out.println("修改：" + update);
//        System.out.println("添加：" + insert);
//        System.out.println("删除：" + delete);
//        System.out.println("左链接：" + leftjoin);

        // 生成byid查询
        // 生成模糊查询 根据and 根据or
        //生成左连接查询
        // 生成右链接查询
        // 生成插入语句
        // 生成修改语句byid
        // 生成修改语句 by 所有字段 和根据and 根据or
        // 生成删除语句byid
        // 生成删除语句 by所有字段 根据and 根据or
        //根据规则生成
        dataBaseTable.build(ab[0],ab[1],ab[2],dataBaseFileds,dataBaseSqls);
        this.dataBaseTables.add(dataBaseTable);
        this.index++;
        return create();
    }


    // 生成 Mapper文件

    // 生成 Dao文件

    // 生成 Service

    // 生成 Controller

    private void createFiles(){

    }

    // 最终创建
    public void build(){
        this.create();
        this.dataBaseInfo.setDataBaseTables(this.dataBaseTables);
        this.createFiles();
    }
}
