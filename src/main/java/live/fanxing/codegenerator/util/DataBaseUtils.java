package live.fanxing.codegenerator.util;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @auther Fanxing
 * 数据库操作(一个Dao层)
 *
 * 先把链接的数据库里的表名全查出来
 * 然后查出这个表所有的外键
 * 创建实体类
 * 填写字段，如果有外键，则将这个外键包含的表给用list和单独的给列进去
 *
 */
@Repository
@Mapper
public interface DataBaseUtils {
    // 根据数据库来获取表

    List<String> getTableListByNowDataBase();
    // 根据表来获取字段
    /**
     * @param
     * @return
     * */
    List<Map<String,Object>> getFieldListByTableName(@Param("tableName") String tableName);
    // 获取表与表之间的关系
    List<Map<String,Object>> getForeginKeyByTableName(@Param("tableName") String tableName);
}
