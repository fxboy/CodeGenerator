package live.fanxing.codegenerator.core.gen;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther fanxing
 * 2021/6/6
 */
@Data
public class Filed {
    // 是否是主键
    boolean isPrimarykey;
    // 是否自增
    boolean isAutoIncrement;
    // 字段名
    String filedName;
    // 属性名
    String attrName;
    // 数据库中类型
    String filedType;
    // 转换成java中的类型
    String javaType;


    public Filed(boolean isPrimarykey, boolean isAutoIncrement, String filedName, String attrName, String filedType, String javaType) {
        this.isPrimarykey = isPrimarykey;
        this.isAutoIncrement = isAutoIncrement;
        this.filedName = filedName;
        this.attrName = attrName;
        this.filedType = filedType;
        this.javaType = javaType;
    }
}
