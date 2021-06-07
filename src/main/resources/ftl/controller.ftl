package ${entity.packageName};

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ${entity.entityPackageName}.${entity.entityName};
import ${entity.daoPackageName}.${entity.serviceName};
import ${entity.resultPackageName}.${entity.resultName};
import java.util.List;

/**
* @auther
* ${entity.className} ServiceImpl
*/

@RestController("/${entity.className}")
public class ${entity.className}Controller{
    @Autowired
    ${entity.serviceName} ${entity.serviceNameXtf}
    /**
    * 根据id查询
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    @RequestMapping("/selectById")
    ${entity.resultName} selectById(${entity.entityName} ${entity.entityNameXtf}){
    return new ${entity.resultName}(200,"查询成功",${entity.daoNameXtf}.selectById(${entity.entityNameXtf}));
    }

    /**
    * 根据条件查询
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    @RequestMapping("/queryOne")
    ${entity.resultName} queryOne(${entity.entityName} ${entity.entityNameXtf}){
    return new ${entity.resultName}(200,"查询成功",${entity.daoNameXtf}.queryOne(${entity.entityNameXtf}));
    }

    /**
    * 查询全部的条数
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    @RequestMapping("/queryAll")
    ${entity.resultName} queryAll(${entity.entityName} ${entity.entityNameXtf}){
    return new ${entity.resultName}(200,"查询成功",${entity.daoNameXtf}.queryAll(${entity.entityNameXtf}));
    }

    /**
    * 查询全部的条数 模糊查询
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    @RequestMapping("/queryAllByLike")
    ${entity.resultName} queryAllByLike(${entity.entityName} ${entity.entityNameXtf}){
    return new ${entity.resultName}(200,"查询成功",${entity.daoNameXtf}.queryAllByLike(${entity.entityNameXtf}));
    }

    /**
    * 添加
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    @RequestMapping("/save")
    ${entity.resultName} save(${entity.entityName} ${entity.entityNameXtf}){
    return new ${entity.resultName}(200,${entity.daoNameXtf}.save(${entity.entityNameXtf})>0?"添加成功":"添加失败");
    }

    /**
    * 修改成功的条数
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    @RequestMapping("/update")
    ${entity.resultName} update(${entity.entityName} ${entity.entityNameXtf}){
    return new ${entity.resultName}(200,${entity.daoNameXtf}.update(${entity.entityNameXtf})>0?"修改成功":"修改失败");
    }

    /**
    * 删除成功的条数
    * @param ${entity.entityNameXtf} ${entity.entityName}实体类
    * @return ${entity.resultName}
    **/
    @RequestMapping("/delete")
    ${entity.resultName} delete(${entity.entityName} ${entity.entityNameXtf}){
    return new ${entity.resultName}(200,${entity.daoNameXtf}.delete(${entity.entityNameXtf})>0?"删除成功":"删除失败");
    }


}
