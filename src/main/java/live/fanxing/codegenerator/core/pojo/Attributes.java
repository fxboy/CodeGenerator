package live.fanxing.codegenerator.core.pojo;

import lombok.Data;

/**
 * @auther fanxing
 * 2021/6/6
 * 当前数据库表中的属性以及属性类型
 */

@Data
public class Attributes {
    String attributeName;
    String attributeType;

    public Attributes(String attributeName, String attributeType) {
        this.attributeName = attributeName;
        this.attributeType = attributeType;
    }
}
