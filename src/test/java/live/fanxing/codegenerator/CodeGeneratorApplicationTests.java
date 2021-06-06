package live.fanxing.codegenerator;

import com.alibaba.fastjson.JSONObject;
import live.fanxing.codegenerator.core.CreateCode;
import live.fanxing.codegenerator.core.Generator;
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

    @Autowired
    Generator generator;

    @Test
    void contextLoads() throws Exception {

        System.out.println("=========开始生成文件========");
        generator.init("com.example.demo","/Users/fanxing/code/","/Users/fanxing/IdeaProjects/CodeGenerator/src/main/resources/ftl").build();
       // createApplication.create("com.example.demo","/Users/fanxing/code/","/Users/fanxing/IdeaProjects/CodeGenerator/src/main/resources/ftl").run();
       // System.out.println(JSONObject.toJSONString(createApplication.getDataBaseInfo()));
    }


}
