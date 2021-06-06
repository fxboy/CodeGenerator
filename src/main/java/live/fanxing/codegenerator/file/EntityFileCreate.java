package live.fanxing.codegenerator.file;

import freemarker.template.Configuration;
import freemarker.template.Template;
import live.fanxing.codegenerator.core.OSinfo;
import live.fanxing.codegenerator.core.pojo.TableEntity;
import live.fanxing.codegenerator.util.ToolsUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther Fanxing
 * 实体类java文件生成
 */
@Component("entity")
public class EntityFileCreate implements FileCreate{
    @Value("${cr.package.entity}")
    String packageName;
    @Value("${cr.model.entity}")
    String modelName;

    @Override
    public void outFiles(String outPath,String modelPath,TableEntity tableEntity) {
        try {
            outPath = outPath +"src\\main\\" +"java\\" + tableEntity.getPackageName().replace(".","\\")  + "\\" +  packageName+"\\";
            ToolsUtils.createFile(outPath + "\\",modelPath,modelName+".ftl",tableEntity.getTableName(),tableEntity);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}