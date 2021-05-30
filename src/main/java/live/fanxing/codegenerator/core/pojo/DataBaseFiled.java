package live.fanxing.codegenerator.core.pojo;

import lombok.Data;

/**
 * @auther Fanxing
 * 这是一个简介
 */

@Data
public class DataBaseFiled {
    // 字段名
    String filedName;
    // 类名
    String className;
    // 方法名
    String attributeName;

    public DataBaseFiled(String filedName, String className, String attributeName) {
        this.filedName = filedName;
        this.className = className;
        this.attributeName = attributeName;
    }
}
