package live.fanxing.codegenerator.core.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @auther Fanxing
 * 这是一个简介
 */

@Data
public class MapperInfo {
    String nameSpace;
    String resultType;
    List<MapperResult> resultList;
    List<MapperResult> association;
    List<MapperResult> collection;
}


