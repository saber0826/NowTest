package com.kuang.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket docket1(){

    return new Docket(DocumentationType.SWAGGER_2).groupName("A");
  }
@Bean
  public Docket docket2(Environment environment){
  //获取项目生产环境
  //设置要显示得swagger环境
     Profiles profiles=Profiles.of("dev","test");
    boolean flag = environment.acceptsProfiles(profiles);

  return new Docket(DocumentationType.SWAGGER_2)
          .enable(flag)//false则会关闭
          //端口选择器选择.basePackage扫描的包.any扫描全部.path指定路径只扫描里面参数的路径
          .groupName("黄")
          .apiInfo(apiInfo())
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.kuang.swagger.controller"))
          .build();}
  private ApiInfo apiInfo() {
  Contact contact = new Contact("黄", "www.danengmao.cn", "www.894930880@qq.com");
    return new ApiInfo("黄的SwaggerAPI文档",
            "Api Documentation",
            "1.0",
            "www.danengmao.cn",
            contact,
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList());

  }
}

