package live.fanxing.codegenerator;

import live.fanxing.codegenerator.util.DataBaseUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@SpringBootTest
class CodeGeneratorApplicationTests {

    @Autowired
    DataBaseUtils dataBaseUtils;
    @Test
    void contextLoads() {
       // System.out.println(dataBaseUtils.getTableListByNowDataBase());
       // System.out.println(dataBaseUtils.getFieldListByTableName("test"));
        // System.out.println(dataBaseUtils.getForeginKeyByTableName("test"));
    }

    @Test
    void createCode(){
        List<String> tableNames = dataBaseUtils.getTableListByNowDataBase();
        //System.out.println(tableNames);
        String[] ab;
        //解析表名是否小驼峰
        for (String tableName: tableNames
             ) {
            ab = jx(tableName);
            //System.out.println("表名：" + ab[0]+"=====" + ab[1] + "====" + ab[2]);

            // 开始解析字段
          List<Map<String,Object>>  fields = dataBaseUtils.getFieldListByTableName(ab[0]);
          List<Map<String,Object>>  forginkeys = dataBaseUtils.getForeginKeyByTableName(ab[0]);
            StringBuffer select = new StringBuffer("select ");
            StringBuffer where = new StringBuffer(" where 1 = 1 ");
            StringBuffer update = new StringBuffer("update ").append(tableName).append(" set ");
            StringBuffer insert = new StringBuffer("insert into ").append(tableName).append("(");
            StringBuffer values = new StringBuffer("values(");
            StringBuffer delete = new StringBuffer("delete from ").append(tableName);
            StringBuffer leftjoin = new StringBuffer("select ");
            for (Map<String, Object> field : fields) {
                String[] abs = jx(field.get("COLUMN_NAME").toString());
                field.put("SDX_COLUMN_NAME",abs[1]);
                field.put("TFS_COLUMN_NAME",abs[2]);
                //System.out.println(field.get("COLUMN_NAME") + "::" + field.get("SDX_COLUMN_NAME")+"::" + field.get("TFS_COLUMN_NAME"));
                // 开始拼接sql语句，比如查询
                select.append(field.get("COLUMN_NAME").toString()).append(" as ").append(field.get("TFS_COLUMN_NAME").toString()).append(fields.get(fields.size() - 1).equals(field)?" ":",");


                leftjoin.append(getSzm(field.get("COLUMN_NAME").toString())).append(".").append(field.get("COLUMN_NAME").toString()).append(fields.get(fields.size() - 1).equals(field)?" ":",");

                if(field.get("COLUMN_KEY").equals("PRI")){
                    where.append(" and ").append(field.get("COLUMN_NAME").toString()).append(" = #{"+ field.get("TFS_COLUMN_NAME") +"}");
                }

                update.append(field.get("COLUMN_NAME").toString()).append(" = ").append("#{"+  field.get("TFS_COLUMN_NAME") +"}").append(fields.get(fields.size() - 1).equals(field)?" ":",");
                if(!field.get("EXTRA").toString().contains("auto_increment")){
                    insert.append(field.get("COLUMN_NAME").toString()).append(fields.get(fields.size() - 1).equals(field)?")":",");
                    values.append("#{"+ field.get("TFS_COLUMN_NAME") +"}").append(fields.get(fields.size() - 1).equals(field)?")":",");
                }




            }
            select.append(" from " + tableName).append(where.toString());
            update.append(where.toString());
            insert.append(values);
            delete.append(where);
            // 开始判断是否有主键
            System.out.println("查询：" + select);
            System.out.println("修改：" + update);
            System.out.println("添加：" + insert);
            System.out.println("删除：" + delete);


        }

    }

    public String[] jx(String value){
        String[] res = new String[3];
        res[0] = value;
        value = value.toLowerCase(Locale.ROOT); // 先全转小写
        String[] vas = value.split("_"); // 查找下划线

        if(vas.length == 1){
            res[1] = toUper(vas[0]);
            res[2] = vas[0];
            return res;
        }
        StringBuffer s = new StringBuffer(vas[0]);
       for (int i = 1 ; i < vas.length ; i ++){
           s.append(toUper(vas[i]));
       }
       res[1] = toUper(s.toString());
       res[2] = s.toString();

        return res;
    }


    public String toUper(String name){
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }

    public String getSzm(String name){
        return name.substring(0,1).toLowerCase(Locale.ROOT);
    }

}
