package ${entity.packageName};

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ${entity.entityPackageName}.${entity.entityName};

import java.util.List;

/**
* @auther
* ${entity.className} Dao层
*/
@Repository
@Mapper
public interface ${entity.className}Dao {
    /**
    * 根据id查询
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.entityName}
    **/
    ${entity.entityName} selectById(${entity.entityName} ${entity.entityNameXtf});

    /**
    * 根据条件查询
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.entityName}
    **/
    ${entity.entityName} queryOne(${entity.entityName} ${entity.entityNameXtf});

    /**
    * 查询全部的条数
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return List<${entity.entityName}>
    **/
    List<${entity.entityName} > queryAll(${entity.entityName} ${entity.entityNameXtf});

    /**
    * 查询全部的条数 模糊查询
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return List<${entity.entityName}>
    **/
    List<${entity.entityName} > queryAllbyLike(${entity.entityName} ${entity.entityNameXtf});

    /**
    * 添加
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return 添加成功的条数
    **/
    Integer save(${entity.entityName} ${entity.entityNameXtf});

    /**
    * 修改成功的条数
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return List<${entity.entityName}>
    **/
    Integer update(${entity.entityName} ${entity.entityNameXtf});

    /**
    * 删除成功的条数
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return List<${entity.entityName}>
    **/
    Integer delete(${entity.entityName} ${entity.entityNameXtf});


}
