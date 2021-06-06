package live.fanxing.codegenerator.core.code;

import live.fanxing.codegenerator.core.OSinfo;
import live.fanxing.codegenerator.core.pojo.Attributes;
import live.fanxing.codegenerator.util.ToolsUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther fanxing
 * 2021/6/6
 * Dao层实体类
 */
@Data
public class Dao {
    String packageName;
    String className;
    String entityName;
    String outPath;
    String modelPath;
    String entityPackageName;
    String entityNameXtf;

    public Dao(String packageName, String className,String outPath, String modelPath,String entityPackageName) {
        this.packageName = packageName;
        this.className = className;
        this.outPath = (OSinfo.isWindows()?outPath +"src\\main\\java\\"+this.packageName.replace(".","\\") + "\\" + className:outPath+ "src\\main\\java\\".replace("\\","/")+this.packageName.replace(".","/") + "/" + className) + "Dao.java";
        this.modelPath = modelPath;
        this.entityName = className;
        this.entityPackageName = entityPackageName;
        this.entityNameXtf = ToolsUtils.jx(this.entityName)[2];
    }
}
