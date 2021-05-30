package live.fanxing.codegenerator;

import com.alibaba.fastjson.JSONObject;
import live.fanxing.codegenerator.core.CreateCode;
import live.fanxing.codegenerator.core.pojo.DataBaseInfo;
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
    CreateCode createCode;

    @Test
    void contextLoads() {

       // List<Map<String,Object>> maps = new ArrayList<>();
       // createCode.init(maps).create();
        DataBaseInfo dataBaseInfo = new DataBaseInfo();
                createCode.init(dataBaseInfo).build();

        System.out.println(JSONObject.toJSONString(dataBaseInfo));

//        new Thread(()->{
//
//        }).run();
    }


}
