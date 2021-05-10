# Swagger
- 号称世界上最流行的Api框架；
- RestFul Api文档在线自动生成工具（Api文档与  API定义同步更新）；
- 直接运行，可以调用在线测试API接口；
- 支持多种语言；
- ......

### SpringBoot集成Swagger
1、Swagger官方网站：[https://swagger.io/](https://swagger.io/)。

2、新建一个SpringBoot-web项目。

3、导入依赖：

* [swagger2](https://mvnrepository.com/artifact/io.springfox/springfox-swagger2/2.9.2)
* [swagger-ui](https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui/2.9.2)

4、编写一个test工程

5、集成Swagger==>config

6、运行项目：[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)。

里面包含：

- Swagger信息
- 接口信息
- 实体类信息
- 组

7、配置Swagger

- Swagger的Docket的bean实例。在里面配置Swagger信息、接口信息、实体类信息和分组。

### 总结

1、可以通过Swagger给一些比较难理解的属性或接口增加注释信息；

2、接口文档实时更新；

3、支持在线测试。

### 注意点

出于安全考虑，在正式发布时，关闭Swagger（禁止他人看到自己的接口，并且还可以节省运行内存）！！！