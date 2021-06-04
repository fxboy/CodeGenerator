package live.fanxing.codegenerator;

import com.alibaba.fastjson.JSONObject;
import live.fanxing.codegenerator.core.CreateCode;
import live.fanxing.codegenerator.core.pojo.DataBaseInfo;
import live.fanxing.codegenerator.core.pojo.DataBaseTable;
import live.fanxing.codegenerator.core.pojo.TableEntity;
import live.fanxing.codegenerator.util.DataBaseUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class CodeGeneratorApplicationTests {

    @Autowired
    DataBaseUtils dataBaseUtils;

    @Autowired
    CreateApplication createApplication;

    @Test
    void contextLoads() throws Exception {

       // List<Map<String,Object>> maps = new ArrayList<>();
        createApplication.create("com.example.demo","B:\\new",null).run();
        System.out.println(JSONObject.toJSONString(createApplication.getDataBaseInfo()));
       // createCode.init("com.example.demo","B:\\new\\",null,dataBaseInfo).build();

//        System.out.println(JSONObject.toJSONString(dataBaseInfo));
//        for (DataBaseTable dataBaseTable : dataBaseInfo.getDataBaseTables()) {
//            System.out.println("======================================");
//            System.out.println(dataBaseTable.getTableEntities().getAttributes());
//            System.out.println(dataBaseTable.getTableEntities().getTableName());
//        }

//        new Thread(()->{
//
//        }).run();
    }


}
