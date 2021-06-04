# 代码生成器
使用SpringBoot + vue开发，文件模板使用FreeMarker模板引擎，可自定义加载和修改
通过脚手架来完成项目的创建以及生成，并通过可视化页面生成Vue页面。
代码生成根据数据库，数据表，字段，外键，以及自定义绑定关系来进行生成，支持多表关联查询

> 生成的Vue页面UI框架：Ant Design of Vue和Element UI

## 目标
### V1 
根据数据库生成：
> 根据自定义绑定数据表关系或者根据外键来生成一对多，多对多等关联查询
- pojo
- Dao
- Mapper
- Service
- Controller
- ResultVO
- Ant Design of Vue pages
- ElementUI pages
 
集成SpringBoot脚手架，直接创建生成好的项目

### V1完成进度
- [x] 生成sql语句
- [x] 生成实体类
