package live.fanxing.codegenerator.file;

import freemarker.template.Configuration;
import freemarker.template.Template;
import live.fanxing.codegenerator.core.pojo.TableEntity;
import live.fanxing.codegenerator.util.ToolsUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther Fanxing
 * 这是一个简介
 */
@Component("entity")
public class EntityFileCreate implements FileCreate{
    @Value("${cr.package.entity}")
    String packageName;
    @Value("${cr.model.entity}")
    String modelName;

    @Override
    public void outFiles(String outPath,String modelPath,TableEntity tableEntity) {
        Configuration configuration = new Configuration();
        System.out.println(tableEntity);
        outPath = outPath +"\\" + tableEntity.getPackageName().replace(".","\\") + "\\" +  packageName;
        //System.out.println(outPath);

        ToolsUtils.createFile(outPath,modelPath,modelName+".ftl",tableEntity.getTableName(),tableEntity);
    }
}
