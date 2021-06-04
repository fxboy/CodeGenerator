package live.fanxing.codegenerator.core.pojo;

import lombok.Data;

import java.util.List;

/**
 * @auther Fanxing
 * 这是一个简介
 */

@Data
public class MapperResult{

    /** 绑定的方法名称
     *  result : 只用到 property,column,javaType
     *  association : 除了column，全用到
     *  collection : 除了column，全用到
     * **/
    String type;
    /** 绑定的方法名称 **/
    String property;

    /** 绑定的字段名称 **/
    String column;

    /** 当前实体类返回的类型 **/
    String javaType;

    List<MapperResult> result;
}
