package ${entity.packageName};

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ${entity.entityPackageName}.${entity.entityName};
import ${entity.daoPackageName}.${entity.daoName};
import ${entity.resultPackageName}.${entity.resultName};
import java.util.List;

/**
* @auther
* ${entity.className} Service
*/
@Service
public interface ${entity.className}Service {
    /**
    * 根据id查询
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    ${entity.resultName} selectById(${entity.entityName} ${entity.entityNameXtf});

    /**
    * 根据条件查询
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    ${entity.resultName} queryOne(${entity.entityName} ${entity.entityNameXtf});

    /**
    * 查询全部的条数
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    ${entity.resultName} queryAll(${entity.entityName} ${entity.entityNameXtf});

    /**
    * 查询全部的条数 模糊查询
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    ${entity.resultName} queryAllByLike(${entity.entityName} ${entity.entityNameXtf});

    /**
    * 添加
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    ${entity.resultName} save(${entity.entityName} ${entity.entityNameXtf});

    /**
    * 修改成功的条数
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    ${entity.resultName} update(${entity.entityName} ${entity.entityNameXtf});

    /**
    * 删除成功的条数
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    ${entity.resultName} delete(${entity.entityName} ${entity.entityNameXtf});


}
