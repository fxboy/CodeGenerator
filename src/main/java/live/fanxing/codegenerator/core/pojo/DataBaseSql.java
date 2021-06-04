package live.fanxing.codegenerator.core.pojo;

import live.fanxing.codegenerator.core.enums.SqlType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @auther Fanxing
 * 生成的字段
 */

@Getter
@Setter
@ToString
public class DataBaseSql {
    SqlType type;
    String methodName;
    String returnType;
    String sql;
    List<MapperInfo> mapperInfoList;

    public DataBaseSql(SqlType type, String methodName, String sql,String returnType) {
        this.type = type;
        this.methodName = methodName;
        this.sql = sql;
        this.returnType = returnType;
    }
}
