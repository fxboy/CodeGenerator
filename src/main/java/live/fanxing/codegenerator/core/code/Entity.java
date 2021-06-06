package live.fanxing.codegenerator.core.code;

import live.fanxing.codegenerator.core.OSinfo;
import live.fanxing.codegenerator.core.pojo.Attributes;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther fanxing
 * 2021/6/6
 * 实体类对象
 */
@Data
public class Entity {
    long serialVersionUID;
    String packageName;
    String className;
    String outPath;
    String modelPath;
    List<Attributes> attributesList;




    public Entity(String packageName, String className,String outPath,String modelPath) {
        this.packageName = packageName;
        this.className = className;
        this.attributesList = new ArrayList<>();
        //outpath = outPath + ; ///Users/fanxing/code/src/main/java/com/example/demo
        this.outPath = (OSinfo.isWindows()?outPath +"src\\main\\java\\"+this.packageName.replace(".","\\") + "\\" + className:outPath+ "src\\main\\java\\".replace("\\","/")+this.packageName.replace(".","/") + "/" + className) + ".java";
        this.modelPath = modelPath;
        this.serialVersionUID = 1L;
    }

    public void addAttr(Attributes attributes){
        this.attributesList.add(attributes);
    }

}
